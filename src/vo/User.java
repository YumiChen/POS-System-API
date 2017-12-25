package vo;

public class User {
	String id;
	String name;
	String email;
	int authcode;
	String password;
	String phone;
	int pid;
	int start;
	int rowsperpage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAuthcode() {
		return authcode;
	}
	public void setAuthcode(int authcode) {
		this.authcode = authcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getRowsperpage() {
		return rowsperpage;
	}
	public void setRowsperpage(int rowsperpage) {
		this.rowsperpage = rowsperpage;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", authcode=" + authcode + ", password="
				+ password + ", phone=" + phone + ", pid=" + pid + ", start=" + start + ", rowsperpage=" + rowsperpage
				+ "]";
	}
	
}
