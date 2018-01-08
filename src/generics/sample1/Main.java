package generics.sample1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Holder1 holder1 = new Holder1(new Automobile("DiDiDi..."));
		Automobile automobile1 = holder1.get();
		automobile1.ring();
		holder1.set(new Automobile("LaLaLa..."));
		Automobile automobile2 = holder1.get();
		automobile2.ring();
	}

}
