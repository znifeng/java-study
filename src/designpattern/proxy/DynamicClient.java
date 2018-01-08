package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicClient {

	public static void main(String[] args) {
		ICoder coder = new JavaCoder("zni");
		InvocationHandler handler = new CoderDynamicProxy(coder);
		ClassLoader classLoader = coder.getClass().getClassLoader();
		ICoder proxy = (ICoder) Proxy.newProxyInstance(classLoader, coder.getClass().getInterfaces(), handler);
		proxy.implDemands("Modify user management.");
		proxy.debug();
	}

}
