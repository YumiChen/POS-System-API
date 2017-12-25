package vo;

public class Vehicle {
	String id;
	String type;
	String menuf;
	String displacement;
	String driver;
	int start;
	int rowsperpage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMenuf() {
		return menuf;
	}
	public void setMenuf(String menuf) {
		this.menuf = menuf;
	}
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
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
		return "Vehicle [id=" + id + ", type=" + type + ", menuf=" + menuf + ", displacement=" + displacement
				+ ", driver=" + driver + ", start=" + start + ", rowsperpage=" + rowsperpage + "]";
	}
}
