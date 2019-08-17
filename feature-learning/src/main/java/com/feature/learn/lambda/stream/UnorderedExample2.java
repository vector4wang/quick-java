package com.feature.learn.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UnorderedExample2 {

	public static void main(String... args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(new Integer(1));
			list.add(new Integer(2));
		}
		//The original list has 10 different object instances but half of them are identical by values
		System.out.println("Original collection with identityHashCodes: ");
		list.forEach(i -> System.out.println(i.toString() + " - " + System.identityHashCode(i)));
		System.out.println("-- distinct ordered --");
		for (int i = 0; i < 5; i++) {//repeat 5 times to check stability
			Stream<Integer> stream = list.stream();
			Object[] objects = stream.parallel().distinct().toArray();
			for (Object object : objects) {
				System.out.print(object.toString() + " - " + System.identityHashCode(object) + " | ");
			}
			System.out.println();
		}
		System.out.println("-- distinct unordered --");
		for (int i = 0; i < 5; i++) {//repeat 5 times to check stability
			Stream<Integer> stream = list.stream();
			Object[] objects = stream.unordered().parallel().distinct().toArray();
			for (Object object : objects) {
				System.out.print(object.toString() + " - " + System.identityHashCode(object) + " | ");
			}
			System.out.println();
		}
	}
}
