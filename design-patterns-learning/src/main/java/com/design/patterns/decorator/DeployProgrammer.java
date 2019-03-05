package com.design.patterns.decorator;

/**
 *
 * @author wangxc
 * @date: 2019/3/5 上午8:01
 *
 */
public class DeployProgrammer extends ProgrammerDecorator {
	public DeployProgrammer(Programmer decorated) {
		super(decorated);
	}

	@Override
	public void coding() {
		super.coding();
		System.out.println("deploy to server!");
	}
}
