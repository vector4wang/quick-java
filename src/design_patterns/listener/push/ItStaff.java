package design_patterns.listener.push;

public class ItStaff implements Interphone {

	private String state;

	@Override
	public void reciveMsg(String msg) {
		this.state = msg;
		System.out.println("IT staff will change state by " + msg);
	}
}
