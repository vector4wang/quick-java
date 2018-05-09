package algorithm.pv4bigdata.waitnotify;

import java.util.Random;

public class Producer extends Thread {
    // 每次生产的产品数量  
    private int num;

    // 所在放置的仓库  
    private Storage storage;

    // 构造函数，设置仓库
    public Producer(Storage storage) {
        do {
            this.storage = storage;
        } while (storage.getList().size() > 0);

    }

    // 线程run函数
    public void run() {
        produce(num);
    }

    // 调用仓库Storage的生产函数
    public void produce(int num) {
        Random random = new Random();
        int size = random.nextInt(num);
        storage.produce(size);
//        for (int i = 0; i < size; i++) {
//            result.add(getRandomString(10));
//        }
//        storage.produce(num);
    }



    // get/set方法
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}  