package vo;

public class InventoryLoss {
	String id;
	String name;
	int price;
	int stock;
	int inventory;
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	@Override
	public String toString() {
		return "InventoryLoss [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", inventory="
				+ inventory + "]";
	}
	
}
