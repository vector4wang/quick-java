package design_patterns.decorator;

public class ProgrammerDecorator implements Programmer {

	protected Programmer decoraptor;

	public ProgrammerDecorator(Programmer decoraptor) {
		this.decoraptor = decoraptor;
	}

	@Override
	public void coding() {
		decoraptor.coding();
	}
}
