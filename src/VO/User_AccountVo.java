package VO;

public class User_AccountVo extends Abs_AccountVo {
	
	private String name;			//VARCHAR2 10
	private String citizen_Number;	//VARCHAR2 15
	private int age;				//NUMBER
	private String User_Tel;			//VARHCAR2 15
	private String email;			//VARCHAR2 40
	
	public User_AccountVo() {
		super();
	}

	public User_AccountVo(String citizen_Number, String name, int age, String user_Tel, String email) {
		super();
		this.citizen_Number = citizen_Number;
		this.name = name;
		this.age = age;
		User_Tel = user_Tel;
		this.email = email;
	}

	
	
	public String getCitizen_Number() {
		return citizen_Number;
	}

	public void setCitizen_Number(String citizen_Number) {
		this.citizen_Number = citizen_Number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUser_Tel() {
		return User_Tel;
	}

	public void setUser_Tel(String User_Tel) {
		this.User_Tel = User_Tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
	
	
	

}
