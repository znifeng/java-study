package annotation;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {
		FruitInfoUtil.getFruitInfo(Apple.class);
		
		//test
		Apple apple = new Apple();
//		System.out.println(apple.getAppleName());
		Field[] fields = Apple.class.getDeclaredFields();
		for (Field field: fields){
			System.out.println(field.getName());
			if (field.getName().equals("appleColor")){
				System.out.println(field.getAnnotation(FruitColor.class).fruitColor().toString());
			}
		}
	}

}
