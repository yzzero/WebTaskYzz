package pres.yinzhenzh.servlet;

/**
 * @author yzz-13008082
 * */
public class User {
	private String username;
	private String password;
	public User() {
		super();
	}
	public User(String username, String password) {
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
	public String getCopy() {
		return "write by &#x6BB7;&#x632F;&#x949F;-13008082 ";
	}
}
