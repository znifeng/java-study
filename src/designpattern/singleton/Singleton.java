package designpattern.singleton;

public class Singleton {
	private static Singleton uniqueInstance;
	private String name;
	private int age;
	private Singleton(){
		name = "zni.feng";
		age=28;
	}
	public synchronized static Singleton getInstance(){
		if (uniqueInstance==null){
			uniqueInstance= new Singleton();
		}
		return uniqueInstance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
