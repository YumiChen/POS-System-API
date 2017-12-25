package vo;

public class Place {
	int id;
	String name;
	String addr;
	String phone;
	String owner;
	int type;
	int start;
	int rowsperpage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	@Override
	public String toString() {
		return "place [id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + ", owner=" + owner
				+ ", type=" + type + ", start=" + start + ", rowsperpage=" + rowsperpage + "]";
	}
	
}
