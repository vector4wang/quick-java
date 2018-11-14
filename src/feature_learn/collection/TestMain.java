package feature_learn.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author vector
 * @date: 2018/11/14 0014 9:31
 */
public class TestMain {
    public static void main(String[] args) {

//        ArrayList al = new ArrayList(10);
//        al.add(3);
//        al.add(2);
//        al.add(1);
//        al.add(4);
//        al.add(5);
//        al.add(6);
//        al.add(6);
//        al.add(3);



//        Iterator iter1 = al.iterator();
//        while(iter1.hasNext()){
//            iter1.remove();
//            System.out.println(iter1.next());
//        }

        System.out.println("===============================================");

        LinkedList ll = new LinkedList();

        for (int i = 0; i < 10000; i++) {
            ll.add(i);
        }

//        long s = System.nanoTime();
//        Object o = ll.get(500000);
//        System.out.println(o);
//
//        long e = System.nanoTime();
//        System.out.println((e-s)/1_000);

        iterateByFori(ll);
        iterateByForEach(ll);
        iterateByIterator(ll);

    }

    //fori方式
    private static void iterateByFori(LinkedList<Integer> linkedList){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        long time2 = System.currentTimeMillis();

        System.out.println("Fori方式遍历的时间花费为："+(time2-time1));
    }

    //foreach方式
    private static void iterateByForEach(LinkedList<Integer> linkedList){
        long time1 = System.currentTimeMillis();
        for (Integer j:linkedList) {
            //TODO
        }
        long time2 = System.currentTimeMillis();

        System.out.println("foreach方式遍历的时间花费为："+(time2-time1));
    }

    //Iterator方式
    private static void iterateByIterator(LinkedList<Integer> linkedList){
        long time1 = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        long time2 = System.currentTimeMillis();

        System.out.println("Iterator方式遍历的时间花费为："+(time2-time1));
    }
}
