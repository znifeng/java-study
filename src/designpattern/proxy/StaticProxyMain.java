package designpattern.proxy;

public class StaticProxyMain {

	public static void main(String[] args) {
		ICoder coder = new JavaCoder("zni");
		ICoder proxy = new CoderProxy("cy", coder);
//		proxy.implDemands("Add user management");
		proxy.implDemands("modify user management");

	}

}
