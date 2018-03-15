package designpattern.strategy;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackNoWay();
	}
	
	@Override
	public void display() {
		System.out.println("I am a ModelDuck.");
		
	}

}
