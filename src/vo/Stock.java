package vo;

public class Stock {
	String iid;
	int pid;
	int num;
	int start;
	int rowsperpage;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
		return "Stock [iid=" + iid + ", pid=" + pid + ", num=" + num + ", start=" + start + ", rowsperpage="
				+ rowsperpage + "]";
	}

}
