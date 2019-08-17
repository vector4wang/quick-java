package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.List;

public class MutableReductionExample {
    public static void main (String[] args) {
        List<String> list = Arrays.asList("Mike", "Nicki", "John");
        runMutableCollect(list);
        runImmutableReduce(list);
    }

    private static void runMutableCollect (List<String> list) {
        String s = list.stream().collect(StringBuilder::new,
                            (sb, s1) -> sb.append(" ").append(s1),
                            (sb1, sb2) -> sb1.append(sb2.toString())).toString();
        System.out.println(s);

		list.stream().collect(StringBuilder::new, (sb, s12) -> sb.append(" ").append(s12),
				(s1, s2) -> s1.append(s2.toString())).toString();
    }

    private static void runImmutableReduce (List<String> list) {
        String s = list.stream().reduce("", (s1, s2) -> s1 + " " + s2);
        System.out.println(s);
    }
}