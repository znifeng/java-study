package designpattern.factory.abstractfactory;

public interface IGFFactory {
	public BaseGF createGF();
	public IGFFather createGFFather();
}
