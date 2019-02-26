package com.feature.learn.parampass;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、= 是赋值操作（任何包含=的如+=、-=、 /=等等，都内含了赋值操作）。不再是你以前理解的数学含义了，而+ - * /和 = 在java中更不是一个级别，换句话说， = 是一个动作，一个可以改变内存状态的操作，一个可以改变变量的符号，而+ - * /却不会。这里的赋值操作其实是包含了两个意思：1、放弃了原有的值或引用；2、得到了 = 右侧变量的值或引用。
 2、操作是完整地复制了变量的值。换句话说，“=之后，你我已无关联”；
 3、对于非基本数据类型变量，= 操作是复制了变量的引用。换句话说，“嘿，= 左侧的变量，你丫别给我瞎动！咱俩现在是一根绳上的蚂蚱，除非你再被 = 一次放弃现有的引用！！上面说了 = 是一个动作，所以我把 = 当作动词用啦！！”。
 4、参数本身是变量，参数传递本质就是一种 = 操作。参数是变量，所有我们对变量的操作、变量能有的行为，参数都有。所以把C语言里参数是传值啊、传指针啊的那套理论全忘掉，参数传递就是 = 操作。
 */
public class TestMain {

	public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		add(list);
		for (Integer j : list) {
			System.err.print(j+",");;
		}
		System.err.println("");
		System.err.println("*********************");
		String a="A";
		append(a);
		System.err.println(a);
		int num = 5;
		addNum(num);
		System.err.println(num);
	}
	
	static void add(List<Integer> list){
		list.add(100);
	}



	static void append(String str){
		str+="is a";
	}


	static void addNum(int a){
		a=a+10;
	}
}