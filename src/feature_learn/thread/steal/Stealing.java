package feature_learn.thread.steal;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * 假如我们需要做一个比较大的任务，我们可以把这个任务分割为若干互不依赖的子任务，
 * 为了减少线程间的竞争，于是把这些子任务分别放到不同的队列里，
 * 并为每个队列创建一个单独的线程来执行队列里的任务，线程和队列一一对应，
 * 比如A线程负责处理A队列里的任务。但是有的线程会先把自己队列里的任务干完，
 * 而其他线程对应的队列里还有任务等待处理。干完活的线程与其等着，不如去帮其他线程干活，
 * 于是它就去其他线程的队列里窃取一个任务来执行。而在这时它们会访问同一个队列，
 * 所以为了减少窃取任务线程和被窃取任务线程之间的竞争，通常会使用双端队列，
 * 被窃取任务线程永远从双端队列的头部拿任务执行，而窃取任务的线程永远从双端队列的尾部拿任务执行。
 * 工作窃取算法的优点是充分利用线程进行并行计算，并减少了线程间的竞争，
 * 其缺点是在某些情况下还是存在竞争，比如双端队列里只有一个任务时。
 * 并且消耗了更多的系统资源，比如创建多个线程和多个双端队列。
 */
public class Stealing {

    private final static int NTHREADS = Runtime.getRuntime().availableProcessors();

    private void work(double[] array, int from, int to) {
        for (int j = from; j < to; j++) {
            array[j] = Math.log(j);
        }
    }

    public void attempt1(final double[] array) {
        Thread[] threads = new Thread[NTHREADS - 1];
        final int segmentLen = array.length / NTHREADS;
        int offset = 0;
        for (int i = 0; i < NTHREADS - 1; i++) {
            final int from = offset;
            final int to = offset + segmentLen;
            threads[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    work(array, from, to);
                }
            });
            threads[i].start();
            offset += segmentLen;
        }
        // do last segment on main thread
        work(array, array.length - segmentLen, array.length);

        // wait for completion
        for (int i = 0; i < NTHREADS - 1; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ignore) {
            }
        }
    }

    public void attempt2(final double[] array) {
        ExecutorService exec = Executors.newFixedThreadPool(NTHREADS - 1);
        final int segmentLen = array.length / NTHREADS;
        int offset = 0;
        for (int i = 0; i < NTHREADS - 1; i++) {
            final int from = offset;
            final int to = offset + segmentLen;
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    work(array, from, to);
                }
            });
            offset += segmentLen;
        }
        // do last segment on main thread
        work(array, array.length - segmentLen, array.length);

        // wait for completion
        exec.shutdown();
        try {
            exec.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ignore) {
        }
    }

    class ForEach extends RecursiveAction {

        private double[] array;
        private int from;
        private int to;

        // you can fine-tune this,
        // should be sth between 100 and 10000
        public final static int TASK_LEN = 5000;

        public ForEach(double[] array, int from, int to) {
            this.array = array;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void compute() {
            int len = to - from;
            if (len < TASK_LEN) {
                work(array, from, to);
            } else {
                // split work in half, execute sub-tasks asynchronously
                int mid = (from + to) >>> 1;
                new ForEach(array, from, mid).fork();
                new ForEach(array, mid, to).fork();
            }
        }
    }

    public void attempt3(final double[] array) {
        ForkJoinPool pool = new ForkJoinPool(NTHREADS);
        // blocks until completion
        pool.invoke(new ForEach(array, 0, array.length));
    }

    public void test() {
        final int ROUNDS = 10;
        long seq = 0, a1 = 0, a2 = 0, a3 = 0, t;

        double[] array = new double[8388608];

        for (int i = 0; i < ROUNDS; i++) {
            t = System.currentTimeMillis();
            work(array, 0, array.length);
            seq += System.currentTimeMillis() - t;
        }
        seq /= ROUNDS;
        print(array);

        clear(array);
        for (int i = 0; i < ROUNDS; i++) {
            t = System.currentTimeMillis();
            attempt1(array);
            a1 += System.currentTimeMillis() - t;
        }
        a1 /= ROUNDS;
        print(array);

        clear(array);
        for (int i = 0; i < ROUNDS; i++) {
            t = System.currentTimeMillis();
            attempt2(array);
            a2 += System.currentTimeMillis() - t;
        }
        a2 /= ROUNDS;
        print(array);

        clear(array);
        for (int i = 0; i < ROUNDS; i++) {
            t = System.currentTimeMillis();
            attempt3(array);
            a3 += System.currentTimeMillis() - t;
        }
        a3 /= ROUNDS;
        print(array);

        System.out.println("sequential avg: " + seq + " ms");
        System.out.println("attempt 1 avg: " + a1 + " ms");
        System.out.println("attempt 2 avg: " + a2 + " ms");
        System.out.println("attempt 3 avg: " + a3 + " ms");
    }

    private void clear(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    private void print(double[] array) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, 10)));
    }

    public static void main(String[] args) {
        new Stealing().test();
    }
}