package vo;

public class Sale {
	String iid;
	int num;
	int pid;
	int start;
	int rowsperpage;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
		return "Sale [iid=" + iid + ", num=" + num + ", pid=" + pid + ", start=" + start + ", rowsperpage="
				+ rowsperpage + "]";
	}

}
