package feature_learn.proxy.again;

public class TestProxy {
	public static void main(String[] args) {
		ProxyHandler proxyHandler = new ProxyHandler();

		Subject itSubject = new ITSubject();

		Subject subjectProxy = (Subject) proxyHandler.bind(itSubject);

		subjectProxy.doSomething();
		subjectProxy.score();
	}
}
