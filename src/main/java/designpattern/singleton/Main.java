package designpattern.singleton;

public class Main {

	public static void main(String[] args) {
//		Singleton zni = Singleton.getInstance();
//		System.out.println(zni.getName() + "_" + zni.getAge());
		Singleton zni = Singleton.getInstance();
		System.out.println(zni.getName() + "_" + zni.getAge());
		

	}

}
