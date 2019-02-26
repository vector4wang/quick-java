package com.feature.learn.proxy;

interface Interface{
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface{

	@Override
	public void doSomething() {
		System.out.println("do Something");
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("something  " + arg);
	}
}

class SimpleProxy implements Interface{

	private Interface proxied;

	public SimpleProxy(RealObject realObject) {
		this.proxied = realObject;
	}

	@Override
	public void doSomething() {
		System.out.println("Simple Proxy do Something");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("Simple Proxy do some thing else " + arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("test");

	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
