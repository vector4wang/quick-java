package design_patterns.listener.push;

public class SalesEmp implements Interphone {
	private String state;
	@Override
	public void reciveMsg(String msg) {
		this.state = msg;
		System.out.println("Sales staff will change state by " + msg);
	}
}
