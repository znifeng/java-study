package designpattern.factory.factory;

public class Main {

	public static void main(String[] args) {
		BaseGF hangZhouGF = new HangzhouGFFactory().createGF();
		hangZhouGF.eatFood();
		hangZhouGF.shopping();
		BaseGF ningBoGF= new NingboGFFactory().createGF();
		ningBoGF.eatFood();
		ningBoGF.shopping();
		BaseGF wenZhouGF= new WenzhouGFFactory().createGF();
		wenZhouGF.eatFood();
		wenZhouGF.shopping();

	}

}
