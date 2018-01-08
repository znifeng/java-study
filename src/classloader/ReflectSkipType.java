package classloader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectSkipType {

	public static void main(String[] args) {
		List list = new ArrayList(); 
	    List<String> list1 = new ArrayList<>(); 
	   
	    list.add("godql");
//	    list1.add(20); //错误的
	    Class c1 = list.getClass();
	    Class c2 = list1.getClass();
	   
	    System.out.println(c1 == c2); // 结果：true，说明类类型完全相同
	    // 反射的操作都是编译之后的操作(运行时)
	   
	    /*
	     * 以上说明编译之后集合的泛型是泛型擦除的
	     * Java中集合的泛型，是防止错误输入的，只在编译阶段有效，绕过编译就无效了。
	     * 验证: 通过方法的反射来操作，绕过编译 
	     */
	    try {
	        // 通过动态操作方法的反射得到add方法
	        Method m = c2.getMethod("add", Object.class);
	        // 方法回调 给list1添加一个int型的，这是在运行时的操作，所以编译器编译时没有泛型检查，所以不会报错
	        // 绕过编译操作
	        m.invoke(list1, 20);
	        // 验证是否有添加进list集合里
	        System.out.println(list1.size()); 
	        // 这时候不能使用foreach遍历，否则集合会认为集合里边全是String类型的值
	        // 且有类型转换错误，因为这个集合里面有int类型、String类
	        System.out.println(list1); 
	    } catch (Exception e) {
	           e.printStackTrace();
	    }

	}

}
