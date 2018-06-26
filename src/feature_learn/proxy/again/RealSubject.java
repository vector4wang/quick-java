package feature_learn.proxy.again;

public class RealSubject implements Subject {
	@Override
	public void doSomething() {
		System.out.println("call doSomething()");
	}

	@Override
	public void score() {
		System.out.println("call score");
	}


}
