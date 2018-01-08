package generics.sample3;

public class Holder3<T> {
	private T t;
	public Holder3(T t){
		this.t = t;
	}
	public T get(){
		return t;
	}
	public void set(T t){
		this.t=t;
	}
}
