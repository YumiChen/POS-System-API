package vo;

public class Item {
	String id;
	String name;
	String menuf;
	int price;
	int cost;
	int safenum;
	int category;
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
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSafenum() {
		return safenum;
	}
	public void setSafenum(int safenum) {
		this.safenum = safenum;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", menuf=" + menuf + ", price=" + price + ", cost=" + cost
				+ ", safenum=" + safenum + ", category=" + category + ", start=" + start + ", rowsperpage="
				+ rowsperpage + "]";
	}

}
