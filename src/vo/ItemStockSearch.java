package vo;

public class ItemStockSearch {
	int start;
	int rowsperpage;
	int pid;
	String term;
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
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "ItemStockSearch [start=" + start + ", rowsperpage=" + rowsperpage + ", pid=" + pid + ", term=" + term
				+ "]";
	}
	


}
