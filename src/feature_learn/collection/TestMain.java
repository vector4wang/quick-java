package feature_learn.collection;

import java.util.*;

/**
 * @author vector
 * @date: 2018/11/14 0014 9:31
 */
public class TestMain {
    public static void main(String[] args) {

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
