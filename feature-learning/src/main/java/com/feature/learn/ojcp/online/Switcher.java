package com.feature.learn.ojcp.online;

public class Switcher {

	public static void main(String[] args) {
		switch (Integer.parseInt(args[1]))  //1
		{
			case 0:
				boolean b = false;
				break;
			case 1:
				b = true; //2
				break;
		}
		//       if(b) System.out.println(args[2]);
	}
}