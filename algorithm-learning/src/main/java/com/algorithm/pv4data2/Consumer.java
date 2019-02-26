package com.algorithm.pv4data2;

public class Consumer implements Runnable {

    private Storage storage;

    public Consumer(Storage storage){
        this.storage = storage;
    }
    
    public void run() {    
        this.beginDealData();        
    }
    
    private void beginDealData(){
        String str = null;
        do{
            str = storage.consume();
            if(str != null){ //当没有数据时，跳出循环
                this.process(str);
            }
        }while(str != null); //当消费的资源为NULL时，则说明工作已经完成，可以跳出循环，结束线程
    }

    // 这里就是实际处理数据的方法
    private void process(String str){
        System.out.println("处理数据：" + str);
    }
}