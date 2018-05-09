package algorithm.pv4bigdata;

import java.util.ArrayList;
import java.util.List;

public class LargDataWithRunnable implements Runnable {

  private static int threadCount = 4;//初始化线程数
  private List<Integer> list;//待处理数据
  private int perCount = 25;//每个线程处理的数据量
  private int flag = 1;//这是第几个线程
  private int count = 123;//待处理数据总数量
  private int havedCount = 0;//已经处理的数据量
  
  //准备数据
  public void data(){
    list = new ArrayList<Integer>();
    for(int i=0; i<count; i++){
      list.add(i);
    }
  }
  
  public void run() {
    List<Integer> sublist;
    while(count - havedCount > 0){//线程会循环执行，直到所有数据都处理完
      synchronized(this){//在分包时需要线程同步，避免线程间处理重复的数据
        sublist = list.subList(perCount*(flag-1), count - havedCount > perCount ? perCount*flag : perCount*(flag-1) + (count - havedCount));
        flag = flag+1;
        havedCount = sublist.size() + havedCount;
      }
      for(int j=0; j<sublist.size(); j++){
        System.out.println(Thread.currentThread().getName() + ":" + sublist.get(j));//此处为数据处理（简单打印 ）
      }
    }
  }
  
  public static void main(String[] args){
    LargDataWithRunnable l = new LargDataWithRunnable();
    l.data();
    for(int i=0; i<threadCount; i++){
      Thread t = new Thread(l);
      t.start();
    }
  }
}