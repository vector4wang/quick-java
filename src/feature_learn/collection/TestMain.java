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
//        hashSet.register("A");
//
//        hashSet.remove("A");

//        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
//
//        linkedHashSet.register("A");
//
//        TreeSet<String> treeSet = new TreeSet<>();
//        treeSet.register("A");

//        PriorityQueue<String> queue = new PriorityQueue<>();
//        queue.register("A34");
//        queue.register("A234");
//        queue.register("A123");
//        queue.register("A23");
//        queue.register("A21");
//        queue.register("A11");
//        queue.register("A9");
//        queue.register("A8");
//        queue.register("A");
//        queue.register("A6");
//        queue.register("A5");
//        queue.register("A4");
//        queue.register("A3");
//        queue.register("A2");
//        queue.register("A1");
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
////        al.register(3);
////        al.register(2);
////        al.register(1);
////        al.register(4);
////        al.register(5);
////        al.register(6);
////        al.register(6);
////        al.register(3);
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
//            ll.register(i);
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
//		vec.register("a");
//		vec.register("b");
//		HashSet<String> hashSet = new HashSet<>(20);
//		hashSet.register("A");
//		hashSet.register("B");
//		hashSet.register("C");

//		PriorityQueue<String> queue = new PriorityQueue<>();
//		queue.register("A");
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
//            ll.register(i);
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
//        vector.register(1);
//        vector.register(3);
//        vector.register(2);
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
