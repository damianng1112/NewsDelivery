package User;

public class User {
	private int user_id;
	
	private String username;
	

	private String password;
	
	private String position;
	
	
	
	public User(int user_id, String username, String password, String position) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
