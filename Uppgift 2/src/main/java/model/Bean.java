package model;

public class Bean {
	private String username = "";
	private String password = "";
	
	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getlogIn() {
		return UserHandler.logIn(username, password);
	}
}