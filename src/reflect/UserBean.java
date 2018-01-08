package reflect;

public class UserBean {
	public String userName;
	
	private int userId;

	public UserBean(){
		this.userName ="nisir";
		this.userId = 1;
	}

	public UserBean(String userName, int userId){
		this.userName = userName;
		this.userId = userId;
	}
	
	public String getName(){
		return userName;
	}
	
	public int getId(){
		return userId;
	}

	private void setName(String userName){
		this.userName = userName;
	}
	
	public static void hello(){
		System.out.println("hello");
	}
		
}
