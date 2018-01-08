package generics.sample2;

public class Holder2 {
	private Object obj;
	public Holder2(Object obj){
		this.obj = obj;
	}
	public Object get(){
		return obj;
	}
	public void set(Object obj){
		this.obj=obj;
	}
}
