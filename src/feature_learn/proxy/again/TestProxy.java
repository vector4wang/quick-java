package feature_learn.proxy.again;

public class TestProxy {
	public static void main(String[] args) {
		ProxyHandler proxyHandler = new ProxyHandler();
		Subject subject = (Subject) proxyHandler.bind(new ITSubject());
		subject.doSomething();
		subject.score();
	}
}
