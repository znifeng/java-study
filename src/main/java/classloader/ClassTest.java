package classloader;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*
		当ClassLoader加载一个class文件到JVM的时候，会自动创建一个该类的Class对象，并且这个对象是唯一的。
		后续要创建这个类的任何实例，都会根据这个Class对象来创建。
		因此每当加载一个class文件的时候，都会创建一个与之对应的Class对象。
		
		Class对象在jvm中的实现源码：
		private Class(ClassLoader loader){
			classLoader = loader;
		}
		即构造器是私有的，意味着只有jvm可以创建Class的对象。我们不能new一个Class对象，但是可以从已有的类得到一个Class对象
		*/
		
		Test test = new Test();
		//获取Class对象的三种方式：
		Class<?> clazz = Test.class;
		Class<?> clazz2 = test.getClass();
		Class<?> clazz3 = Class.forName("classloader.Test");
		
		Test test1 = (Test) clazz.newInstance();
		test1.say();
		
		Test test2 = (Test) clazz2.newInstance();
		test2.say();
		
		Test test3 = (Test) clazz3.newInstance();
		test3.say();

	}

}
