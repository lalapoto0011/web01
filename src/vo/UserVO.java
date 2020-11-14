package vo; //VO 대신 DTO, bookRDC가 들어가기도 함.. 같은 말임

//BoardVO, UserVO 등 만들 수 있겠다.
public class UserVO {
	private String id ; //int(4) PRIMARY KEY auto_increment,
	private String password ; //VARCHAR(40),
	private String name ; //VARCHAR(40),
	private String role ; //int(8)

	public UserVO() {
		super(); //생략해도 자동으로 들어가긴 함.
	} 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + ", getId()="
				+ getId() + ", getPassword()=" + getPassword() + ", getName()=" + getName() + ", getRole()=" + getRole()
				+ "]";
	}

	
}
