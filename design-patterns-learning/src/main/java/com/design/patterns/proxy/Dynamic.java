package com.design.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author wangxc
 * @date: 2019-10-23 23:15
 *
 */
public class Dynamic {
	static class MyHandler implements InvocationHandler {

		private Object proxyed;

		public MyHandler(Object proxyed) {
			this.proxyed = proxyed;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println(">>> before invoking");
			Object invoke = method.invoke(this.proxyed, args);
			System.out.println(">>> after invoking");
			return invoke;
		}
	}

	public static Object agent(Class interfaceClazz, Object proxy) {
		return Proxy
				.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz}, new MyHandler(proxy));
	}
}
