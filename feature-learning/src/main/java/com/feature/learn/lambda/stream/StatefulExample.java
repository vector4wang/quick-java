package com.feature.learn.lambda.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class StatefulExample {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Set<Integer> seen = new HashSet<>();
			IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
			int sum = stream.parallel().map(
					//stateful behavioral parameter.
					e -> {
						try {//making it bit slow for more thread
							//interference changes
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						if (seen.add(e))
							return e;
						else
							return 0;
					}).sum();
			System.out.println(sum);

		}
	}
}