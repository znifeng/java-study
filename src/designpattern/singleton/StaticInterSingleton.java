package designpattern.singleton;

public class StaticInterSingleton {
	private static class Holder{
		private static final StaticInterSingleton INSTANCE = new StaticInterSingleton();
	}
	private static StaticInterSingleton uniqueInstance;
	public StaticInterSingleton getInstance(){
		if (null==uniqueInstance){
			uniqueInstance= Holder.INSTANCE;
		}
		return uniqueInstance;
	}

}
