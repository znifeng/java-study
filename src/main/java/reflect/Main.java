package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) {
		Class<?> userBeanClass  = UserBean.class;
		printFields(userBeanClass);
		printMethods(userBeanClass);
		printConstructor(userBeanClass);
		invokeMethods(userBeanClass);
	}
	
	public static <T> void printFields(Class<T> userBeanClass){
		System.out.println("\n==================Field======================");
		Field[] fields = userBeanClass.getDeclaredFields(); 
		for (Field field : fields){
			String fieldString = "";
			fieldString+=Modifier.toString(field.getModifiers()) + " ";  //private、static、protect、public等修饰符
			fieldString+=field.getType().getSimpleName() + " "; // String、int等域类型
			fieldString+=field.getName(); //userName、userId等域名
			fieldString+=";";
			System.out.println(fieldString);
		}
	}
	
	public static <T> void printMethods(Class<T> userBeanClass){
		System.out.println("\n==================Method======================");
		Method[] methods = userBeanClass.getDeclaredMethods();
		for (Method method:methods){
			String methodString = "";
			methodString += Modifier.toString(method.getModifiers()) + " "; //private、static、protect、public等修饰符
			methodString += method.getReturnType().getSimpleName() + " "; //String、int等返回类型
			methodString += method.getName() + "(";
			Class<?>[] paramTypes = method.getParameterTypes(); //获取方法包含的参数类型
			for (Class<?> paramType : paramTypes){
				methodString += paramType.getSimpleName() + " "; //参数类型
			}
			methodString += ")";
			System.out.println(methodString);
		}
	}
	
	public static <T> void printConstructor(Class <T> userBeanClass){
		System.out.println("\n==================Constructor======================");
		Constructor<?> [] constructors = userBeanClass.getDeclaredConstructors();
		for (Constructor<?> constructor:constructors){
			String constructorString="";
			constructorString += Modifier.toString(constructor.getModifiers()) + " "; //private、static、protect、public等修饰符
			constructorString +=constructor.getName() + "(";
			Class<?>[] parameters = constructor.getParameterTypes();//获取构造函数包含的参数类型
			for (Class<?> parameter : parameters){
				constructorString+=parameter.getSimpleName()+ ", "; //参数类型
			}
			constructorString =constructorString.substring(0, constructorString.length()-1);
			constructorString+=")";
			System.out.println(constructorString);
		}
	}
	
	public static <T> void invokeMethods(Class <T> userBeanClass){
		System.out.println("\n==================Invoke Method======================");
		try {
			Class<?>[] params = {String.class, int.class};
			Constructor<?> defaultConstructor = userBeanClass.getDeclaredConstructor(); //获取默认构造函数
			Object userBean1 = defaultConstructor.newInstance(); //通过默认构造函数实例化一个对象
			Constructor<?> paramConstructor = userBeanClass.getDeclaredConstructor(params);//获取带参数的构造函数
			Object userBean2 = paramConstructor.newInstance("Nizhifeng", 2);//通过构造函数实例化一个对象
			
			//获取各个方法
			Method getNameMethod = userBeanClass.getDeclaredMethod("getName");
			Method getIdMethod = userBeanClass.getDeclaredMethod("getId");
			Method setNameMethod = userBeanClass.getDeclaredMethod("setName", String.class);
			Method helloMethod = userBeanClass.getDeclaredMethod("hello");
			
			//user1
			Object name = getNameMethod.invoke(userBean1);
			Object id = getIdMethod.invoke(userBean1);
			System.out.println("user1 is "+name);
			System.out.println("user1's id is "+ id);
			setNameMethod.setAccessible(true); //private方法必须setAccessible后才能invoke
			setNameMethod.invoke(userBean1, "cy");
			name = getNameMethod.invoke(userBean1);
			System.out.println("user1 changed to " + name);
			
			//user2
			name = getNameMethod.invoke(userBean2);
			System.out.println("user2 is "+name);
			id = getIdMethod.invoke(userBean2);
			System.out.println("user2's id is " + id);
			
			helloMethod.invoke(null);//静态方法不需要传实例对象
			
			UserBean userBean3 = (UserBean) defaultConstructor.newInstance();
			System.out.println(userBean3.getName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
