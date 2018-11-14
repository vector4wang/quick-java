package feature_learn.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IDEA
 * User: vector
 * Data: 2018/5/10 0010
 * Time: 9:03
 * Description:
 */
public class FutureTest {

    public void print(String test) {
        System.out.println(test);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long stat = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<ServiceThread> callList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            callList.add(new ServiceThread(i,new FutureTest()));
        }
        List<Future<Integer>> futures = executorService.invokeAll(callList);
        executorService.shutdown();

        System.out.println("--->等一会处理其他东西，再要结果<---");

        int sum = 0;
        for (Future<Integer> item : futures) {
            sum += item.get();
        }

        long end = System.currentTimeMillis();
        double time = (double) (end - stat) / 1000;

        System.out.println("结果: " + sum + " 耗时: " + time + "s");
    }
}

class ServiceThread implements Callable<Integer> {

    private int num;

    private FutureTest futureTest;

    public ServiceThread(int num,FutureTest futureTest) {
        this.num = num;
        this.futureTest = futureTest;
    }

    @Override
    public Integer call() throws Exception {
        futureTest.print(num+"");
        System.out.println(Thread.currentThread().getName() + "--->执行中");
        Thread.sleep(10);
        return num;
    }
}
