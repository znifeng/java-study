package designpattern.factory.simplefactory;

public class Main {

	public static void main(String[] args) {
		BaseGF hangZhouGF = GFFactory.createGF(GFType.HANG_ZHOU);
		hangZhouGF.eatFood();
		hangZhouGF.shopping();
		BaseGF ningBoGF= GFFactory.createGF(GFType.NING_BO);
		ningBoGF.eatFood();
		ningBoGF.shopping();
		BaseGF wenZhouGF= GFFactory.createGF(GFType.WEN_ZHOU);
		wenZhouGF.eatFood();
		wenZhouGF.shopping();

	}

}
