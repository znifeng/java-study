package collection;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//ArrayList其实add的元素，不是对象本身，而是指向对象的引用
		List<Student> classmates = new ArrayList<>();
		Student s = new Student();
		s.setAge(26);
		s.setName("zni");
		classmates.add(s);
		classmates.add(s);
		System.out.println(classmates.get(0).getName());
		System.out.println(classmates.get(1).getName());
		classmates.get(0).setName("cy");
		System.out.println(classmates.get(0).getName());
		System.out.println(classmates.get(1).getName());

	}

}
