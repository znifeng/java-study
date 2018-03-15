package designpattern.factory.factory;

public class NingboGFFactory implements IGFFactory{
	@Override
	public BaseGF createGF(){
		return new NingboGF();
	}

}
