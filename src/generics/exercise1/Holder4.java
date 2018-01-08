package generics.exercise1;

import java.util.ArrayList;
import java.util.List;

public abstract class Holder4<T> {
	private List<T> e;
	public Holder4(){
		e = new ArrayList<T>();
	}
	public void add(T t){
		e.add(t);
	}
	public void delete(int index){
		e.remove(index);
	}
	public List<T> get(){
		return e;
	}
	public abstract void read();
}
