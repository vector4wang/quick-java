package effectivejava.generic;

import java.util.HashSet;
import java.util.Set;

public class UnboundedWildcardType {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<>();
		s1.add("1");
		s1.add("2");

		Set<Integer> s2 = new HashSet<>();
		s2.add(1);
		s2.add(2);

		int i = numElementsInCommon1(s1, s2);
		System.out.println(i);
	}

	/**
	 * 无限制通配符类型(Unbounded wildcard type)
	 * 不确定或者不关心实际的类型参数，可以使用此(?代替)
	 * @param s1
	 * @param s2
	 * @return
	 */
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o : s1) {
			if (s2.contains(o)) {
				result++;
			}
		}

		return result;
	}

	/**
	 * 原生态类型，可以但不安全
	 * @param s1
	 * @param s2
	 * @return
	 */
	static int numElementsInCommon1(Set s1, Set s2) {
		int result = 0;
		for (Object o : s1) {
			if (s2.contains(o)) {
				result++;
			}
		}

		return result;
	}
}
