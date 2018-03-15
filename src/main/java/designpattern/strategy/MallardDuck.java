package designpattern.strategy;

public class MallardDuck extends Duck{
	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new QuackWithGuaGua();
	}

	@Override
	public void display() {
		System.out.println("I am a MallardDuck.");
		
	}
}
