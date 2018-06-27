package feature_learn.proxy.again;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

	private Object tar;

	public Object bind(Object tar) {
		this.tar = tar;
		return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		if ("score".equals(method.getName())) {
			System.out.println("before");
			result = method.invoke(tar, args);
		}
		return result;
	}
}
