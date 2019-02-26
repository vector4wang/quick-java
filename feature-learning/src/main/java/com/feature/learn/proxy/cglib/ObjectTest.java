package com.feature.learn.proxy.cglib;


import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.Random;

class ObjectCalculate {

	public char cal(String arg) {
		char c = arg.charAt(new Random().nextInt(arg.length()));
		System.out.println("经过某种计算得出了结果: " + c);
		return c;
	}

	public char cal2(String arg) {
		char c = arg.charAt(new Random().nextInt(arg.length()-1));
		System.out.println("经过某种计算得出了结果: " + c);
		return c;
	}


}

class ObjProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("MethodInterceptor start...");
		methodProxy.invokeSuper(proxyObj,args);
		System.out.println("MethodInterceptor ending...");
		return null;
	}
}

class ObjFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		if ("cal2".equalsIgnoreCase(method.getName())) {
			return 0;
		}
		return 1;
	}
}

public class ObjectTest {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ObjectCalculate.class); //设置被代理的类
		enhancer.setCallbacks(new Callback[]{new ObjProxy(),NoOp.INSTANCE}); //根据SubClass中的实现对方法进行增强
		enhancer.setCallbackFilter(new ObjFilter()); //使用过滤器
		ObjectCalculate create = (ObjectCalculate)enhancer.create();

		create.cal("ken");

		//使用enhancer产生的代理类不需要修改SuperClass类中的代码，就可以对bye()进行增强
		create.cal2("ken");
	}
}