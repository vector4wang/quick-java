package feature_learn.proxy.again;

public class ITSubject implements Subject {
	@Override
	public void doSomething() {
		System.out.println("need online");
	}

	@Override
	public void score() {
		System.out.println("need add online score");
	}
}
