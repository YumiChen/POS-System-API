package vo;

public class AnalysisResult_ {
	String name;
	int sales;
	int num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "AnalysisResult_ [name=" + name + ", sales=" + sales + ", num=" + num + "]";
	}
	
}
