package vo;

public class ItemStock {
	String id;
	String name;
	String menuf;
	int price;
	String category;
	int stock;
	String pname;
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
	public String getMenuf() {
		return menuf;
	}
	public void setMenuf(String menuf) {
		this.menuf = menuf;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "ItemStock [id=" + id + ", name=" + name + ", menuf=" + menuf + ", price=" + price + ", category="
				+ category + ", stock=" + stock + ", pname=" + pname + ", pid=" + pid + ", start=" + start
				+ ", rowsperpage=" + rowsperpage + "]";
	}

	
}
