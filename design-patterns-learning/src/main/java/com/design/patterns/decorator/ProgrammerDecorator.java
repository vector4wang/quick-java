package com.design.patterns.decorator;

public class ProgrammerDecorator implements Programmer {

	/**
	 * 被装饰对象
	 */
	protected Programmer decorated;

	public ProgrammerDecorator(Programmer decorated) {
		this.decorated = decorated;
	}

	@Override
	public void coding() {
        decorated.coding();
	}
}
