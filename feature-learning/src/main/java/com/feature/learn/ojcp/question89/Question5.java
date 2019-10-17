package com.feature.learn.ojcp.question89;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 16:25
 *
 */
public class Question5 {
}

abstract class Planet {
	protected void resolve() {
	}

	abstract void rotate();
}

class Earth extends Planet {

	@Override
	public void resolve() {
		super.resolve();
	}

	@Override
	public void rotate() {
	}
}