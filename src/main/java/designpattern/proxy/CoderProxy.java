package designpattern.proxy;

public class CoderProxy implements ICoder {
	private String name;
	private ICoder coder;
	
	public CoderProxy(String name, ICoder coder) {
		this.name = name;
		this.coder = coder;
	}

	@Override
	public void implDemands(String demandName) {
		System.out.println("I am " +  this.name );
		if (demandName.startsWith("Add")){
			System.out.println("No longer receive 'Add' demands.");
			return;
		}
		coder.implDemands(demandName);
		
	}

	@Override
	public void debug() {
		System.out.println("I can not debug.");
		
	}
	
	
}
