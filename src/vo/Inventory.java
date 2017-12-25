package vo;

public class Inventory {
	String iid;
	String pid;
	int difference;
	int start;
	int rowsperpage;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getDifference() {
		return difference;
	}
	public void setDifference(int difference) {
		this.difference = difference;
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
		return "Inventory [iid=" + iid + ", pid=" + pid + ", difference=" + difference + ", start=" + start
				+ ", rowsperpage=" + rowsperpage + "]";
	}

	
}
