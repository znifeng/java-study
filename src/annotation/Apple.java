package annotation;

import annotation.FruitColor.Color;

public class Apple {
	@FruitName("Apple")
	private String appleName;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;

	@FruitProvider(id=1, name="红富士集团", address="红富士大厦")
	private String appleProvider;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}
	
	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
	
	public void display(){
		System.out.println("The fruit name is：" + appleName + ", its color is: " + appleColor + ".");
	}
	
}
