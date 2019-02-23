package design_patterns.listener.pull.abs;


import design_patterns.listener.pull.Interphone;

import java.util.ArrayList;
import java.util.List;

public class BlockBoard {
	public List<Interphone> staffList = new ArrayList<>();

	private String txt;

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
		notifyStaff();
	}

	public void register(Interphone telescope) {
		staffList.add(telescope);
		System.out.println("register a staff");
	}

	public void del(Interphone telescope) {
		staffList.remove(telescope);
		System.out.println("just has " + staffList.size());
	}

	protected void notifyStaff() {
		for (Interphone interphone : staffList) {
			interphone.reciveMsg();
		}
	}
}
