package classloader;

public class Main {

	public static void main(String[] args) {
		Test test = new Test();
		test.say();
		//得到当前的类加载器ApplicationClassLoader
		ClassLoader cl = Test.class.getClassLoader();
		System.out.println(cl.toString());
		//得到ApplicationClassLoader的父类加载器ExtensionClassLoader
		ClassLoader extCl = cl.getParent();
		System.out.println(extCl.toString());
		//得到ExtensionClassLoader的父类加载器BootstrapClassLoader
		//由于BootstrapClassLoader是用C/C++语言编写的，在java中无法直接使用。因此会返回一个null
		ClassLoader bootCl = extCl.getParent();
		System.out.println(bootCl);
	}

}
