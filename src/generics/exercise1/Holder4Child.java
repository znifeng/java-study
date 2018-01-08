package generics.exercise1;

import java.util.Iterator;
import java.util.List;

public class Holder4Child extends Holder4<String>{

	@Override
	public void read() {
		List<String> e = get();
		Iterator<String> iter = e.iterator();
		String str = "";
		while (iter.hasNext()){
			str+=iter.next();
			str+=" ";
		}
		System.out.println(str);
	}



	
}
