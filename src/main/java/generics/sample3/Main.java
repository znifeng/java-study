package generics.sample3;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Holder3<Automobile> holder3 = new Holder3<Automobile>(new Automobile("DiDiDi..."));
		Automobile automobile1 = holder3.get();
		automobile1.ring();
		holder3.set(new Automobile("DiDaDi..DiDaDi..."));
		Automobile automobile2 = holder3.get();
		automobile2.ring();
	}

}
