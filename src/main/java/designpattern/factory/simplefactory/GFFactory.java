package designpattern.factory.simplefactory;

public class GFFactory {
	public static BaseGF createGF(GFType gfType){
			switch(gfType){
				case HANG_ZHOU:
					return new HangzhouGF();
				case NING_BO:
					return new NingboGF();
				default:
				case WEN_ZHOU:
					return new WenzhouGF();
			}
	}
}
