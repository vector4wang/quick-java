package com.design.patterns.listener.push.abs;


import com.design.patterns.listener.push.Interphone;

import java.util.ArrayList;
import java.util.List;


public class BlackBoard {

	public List<Interphone> staffList = new ArrayList<>();

	public void register(Interphone telescope) {
		staffList.add(telescope);
		System.out.println("register a staff");
	}

	public void del(Interphone telescope) {
		staffList.remove(telescope);
		System.out.println("just has " + staffList.size());
	}

	protected void notifyStaff(String msg) {
		for (Interphone interphone : staffList) {
			interphone.reciveMsg(msg);
		}
	}
}
