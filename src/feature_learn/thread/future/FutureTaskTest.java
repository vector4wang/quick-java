package feature_learn.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IDEA
 * User: vector
 * Data: 2018/5/10 0010
 * Time: 9:06
 * Description:
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            FutureTask<Integer> integerFutureTask = new FutureTask<>(new TaskServiceThread(i));
            futureTasks.add(integerFutureTask);

            executor.submit(integerFutureTask);
        }
        executor.shutdown();

        System.out.println("--->主线程在做事<---");
        Thread.sleep(1000);

        long stat = System.currentTimeMillis();
        int sum = 0;
        for (FutureTask<Integer> futureTask : futureTasks) {
            sum += futureTask.get();
        }

        long end = System.currentTimeMillis();
        double time = (double) (end - stat) / 1000;
        System.out.println("结果: " + sum + " 耗时: " + time + "s");

    }

}

class TaskServiceThread implements Callable<Integer> {

    private int num;

    public TaskServiceThread(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "--->执行中");
        Thread.sleep(1000);
        return num;
    }
}