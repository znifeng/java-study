package designpattern.factory.factory;

public class HangzhouGFFactory implements IGFFactory {

	@Override
	public BaseGF createGF() {
		return new HangzhouGF();
	}
	
}
