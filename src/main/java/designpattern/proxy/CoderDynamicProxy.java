package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CoderDynamicProxy implements InvocationHandler{
	private ICoder coder;
	
	public CoderDynamicProxy(ICoder coder) {
		this.coder = coder;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(System.currentTimeMillis());
		Object result = method.invoke(coder, args);
		System.out.println(System.currentTimeMillis());
		return null;
	}

}
