package com.feature.learn.ojcp.question89;



import java.util.ArrayList;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 16:16
 *
 */
public class Question1 {
	public static void main(String[] args) {
		ArrayList<Vehicle> myList = new ArrayList<Vehicle>();
		myList.add(new Motorcycle());
	}
}

//class Vehicle {
//
//}
//
//class Motorcycle extends Vehicle {
//
//}

interface Vehicle {

}

class Motorcycle implements Vehicle {

}
