package designpattern.strategy;

public class QuackNoWay implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I can not quack.");
		
	}

}
