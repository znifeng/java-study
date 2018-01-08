package generics.sample1;

public class Holder1 {
	private Automobile automobile;
	public Holder1(Automobile automobile){
		this.automobile= automobile;
	}
	public Automobile get(){
		return automobile;
	}
	public void set(Automobile automobile){
		this.automobile=automobile;
	}
}
