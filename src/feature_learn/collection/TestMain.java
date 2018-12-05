package feature_learn.collection;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author vector
 * @date: 2018/11/14 0014 9:31
 */
public class TestMain {
    public static void main(String[] args) {
//        int h = "A".hashCode();
//        System.out.println(h);
//        int i = h >>> 16;
//        System.out.println(i);
//        System.out.println(h ^ i);

//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("A");
//
//        hashSet.remove("A");

//        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
//
//        linkedHashSet.add("A");
//
//        TreeSet<String> treeSet = new TreeSet<>();
//        treeSet.add("A");

//        PriorityQueue<String> queue = new PriorityQueue<>();
//        queue.add("A34");
//        queue.add("A234");
//        queue.add("A123");
//        queue.add("A23");
//        queue.add("A21");
//        queue.add("A11");
//        queue.add("A9");
//        queue.add("A8");
//        queue.add("A");
//        queue.add("A6");
//        queue.add("A5");
//        queue.add("A4");
//        queue.add("A3");
//        queue.add("A2");
//        queue.add("A1");
//        System.out.println(queue);


        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        arrayBlockingQueue.add("A");
        arrayBlockingQueue.add("B");
        arrayBlockingQueue.add("C");

        System.out.println(arrayBlockingQueue);



//        int number = 10;
//        //原始数二进制
//        printInfo(number);
//        number = number << 1;
//        //左移一位
//        printInfo(number);
//        number = number >> 1;
//        //右移一位
//        printInfo(number);
//
//        number = number >>> 1;
//
//        System.out.println(number);

//        hashSet.

//        ArrayList al = new ArrayList(10);
////        al.add(3);
////        al.add(2);
////        al.add(1);
////        al.add(4);
////        al.add(5);
////        al.add(6);
////        al.add(6);
////        al.add(3);
//
//
//
////        Iterator iter1 = al.iterator();
////        while(iter1.hasNext()){
////            iter1.remove();
////            System.out.println(iter1.next());
////        }
//
//        System.out.println("===============================================");
//
//        LinkedList ll = new LinkedList();
//		ll.remove(1);
//
//        for (int i = 0; i < 10000; i++) {
//            ll.add(i);
//        }
//
////        long s = System.nanoTime();
////        Object o = ll.get(500000);
////        System.out.println(o);
////
////        long e = System.nanoTime();
////        System.out.println((e-s)/1_000);
//
////        iterateByFori(ll);
////        iterateByForEach(ll);
////        iterateByIterator(ll);
//		Vector<String> vec = new Vector<>();
//		vec.add("a");
//		vec.add("b");
//		HashSet<String> hashSet = new HashSet<>(20);
//		hashSet.add("A");
//		hashSet.add("B");
//		hashSet.add("C");

//		PriorityQueue<String> queue = new PriorityQueue<>();
//		queue.add("A");
//		queue.contains("A");
//		queue.remove("A");
		int h = "B".hashCode();
		System.out.println(h);
		int yz = h >>> 16;

		System.out.println(h ^ yz);

		Map<String, String> map = new HashMap<>();
		map.put("A", "asdf");
		map.put("B", "asdf");
		map.put("C", "asdf");
		map.put("D", "asdf");
		map.containsKey("A");
		map.remove("B");
		map.get("C");
		map.hashCode();

//        System.out.println("===============================================");
//
//        LinkedList ll = new LinkedList();
//
//        for (int i = 0; i < 10000; i++) {
//            ll.add(i);
//        }
//
////        long s = System.nanoTime();
//        Object o = ll.get(500000);
//        System.out.println(o);
//
//        long e = System.nanoTime();
//        System.out.println((e-s)/1_000);

//        iterateByFori(ll);
//        iterateByForEach(ll);
//        iterateByIterator(ll);
//
//
//
//        Vector<Integer> vector = new Vector<>();
//        vector.add(1);
//        vector.add(3);
//        vector.add(2);
//
//
//        vector.get(1);

    }

    private static void printInfo(int num){
         System.out.println(Integer.toBinaryString(num));
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
