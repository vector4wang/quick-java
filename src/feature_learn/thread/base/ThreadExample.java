package feature_learn.thread.base;


public class ThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " 主程序执行第一句代码");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 子线程执行");
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + " 主程序执行第二部");
    }
}
