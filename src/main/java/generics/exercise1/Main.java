package generics.exercise1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Holder4Child holder4Child = new Holder4Child();
		holder4Child.add("Yes,");
		holder4Child.add("today");
		holder4Child.add("is not Tuesday.");
		holder4Child.read();
		holder4Child.delete(2);
		holder4Child.read();
	}

}
