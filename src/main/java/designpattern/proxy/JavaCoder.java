package designpattern.proxy;

public class JavaCoder implements ICoder {
	private String name;
	
	public JavaCoder(String name) {
		this.name = name;
	}

	@Override
	public void implDemands(String demandName) {
		System.out.println(this.name + " implemented demand: " + demandName + " in Java.");
		
	}

	@Override
	public void debug() {
		System.out.println("Debug in Java.");
		
	}

}
