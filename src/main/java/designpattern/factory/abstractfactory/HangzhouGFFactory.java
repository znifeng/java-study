package designpattern.factory.abstractfactory;

public class HangzhouGFFactory implements IGFFactory {

	@Override
	public BaseGF createGF() {
		return new HangzhouGF();
	}

	@Override
	public IGFFather createGFFather() {
		return new HangzhouGFFather();
	}
	
}
