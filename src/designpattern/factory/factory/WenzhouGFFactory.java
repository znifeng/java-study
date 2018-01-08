package designpattern.factory.factory;

public class WenzhouGFFactory implements IGFFactory{

	@Override
	public BaseGF createGF() {
		return new WenzhouGF();
	}

}
