package generics.sample2;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Holder2 holder2 = new Holder2(new Automobile("DiDiDi..."));
		Automobile automobile1 = (Automobile) holder2.get();
		automobile1.ring();
		holder2.set("Yes, I do.");
		String str = (String) holder2.get();
		System.out.println(str);
	}

}
