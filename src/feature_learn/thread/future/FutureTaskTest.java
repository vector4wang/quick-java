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
        ExecutorService executor = Executors.newFixedThreadPool(25);
        List<FutureTask<String>> futureTasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 1000; j++) {
				FutureTask<String> integerFutureTask = new FutureTask<>(new TaskServiceThread(i+"->"+j));
				futureTasks.add(integerFutureTask);

				executor.submit(integerFutureTask);
			}
			long stat = System.currentTimeMillis();
			int sum = 0;
			for (FutureTask<String> futureTask : futureTasks) {
				futureTask.get();
			}

			long end = System.currentTimeMillis();
			double time = (double) (end - stat) / 1000;
			System.out.println(i+"===>结果: " + sum + " 耗时: " + time + "s");
			futureTasks.clear();

        }
        executor.shutdown();

        System.out.println("--->主线程在做事<---");
        Thread.sleep(1000);



    }

}

class TaskServiceThread implements Callable<String> {

    private String num;

    public TaskServiceThread(String num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "--->执行中["+num+"]");
        Thread.sleep(5);
        return num;
    }
}