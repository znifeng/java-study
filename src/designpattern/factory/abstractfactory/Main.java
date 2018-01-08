package designpattern.factory.abstractfactory;

public class Main {

	public static void main(String[] args) {
		BaseGF hangZhouGF = new HangzhouGFFactory().createGF();
		IGFFather hangZhouFather = new HangzhouGFFactory().createGFFather();
		hangZhouGF.eatFood();
		hangZhouGF.shopping();
		hangZhouFather.suggest2me();

	}

}
