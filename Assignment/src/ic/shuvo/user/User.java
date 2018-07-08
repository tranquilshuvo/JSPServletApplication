package ic.shuvo.user;

public class User {
	
	int id;
	String userName;
	String password;
	String userId;
	
	/*public User(int id, String userName, String password, String userId) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userId = userId;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
/*	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", userId=" + userId + "]";
	}*/
	
	
	
}
