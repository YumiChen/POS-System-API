package vo;

public class Order {
	String id;
	int status;
	String senderid;
	String senddate;
	int sourceid;
	int pid;
	String requesterid;
	String wishdate;
	int istransfer = 2;
	int valid = 2;
	
	int start;
	int rowsperpage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getSourceid() {
		return sourceid;
	}
	public void setSourceid(int sourceid) {
		this.sourceid = sourceid;
	}
	public int getIstransfer() {
		return istransfer;
	}
	public void setIstransfer(int istransfer) {
		this.istransfer = istransfer;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public String getRequesterid() {
		return requesterid;
	}
	public void setRequesterid(String requesterid) {
		this.requesterid = requesterid;
	}
	public String getWishdate() {
		return wishdate;
	}
	public void setWishdate(String wishdate) {
		this.wishdate = wishdate;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", senderid=" + senderid + ", senddate=" + senddate
				+ ", sourceid=" + sourceid + ", pid=" + pid + ", requesterid=" + requesterid + ", wishdate=" + wishdate
				+ ", istransfer=" + istransfer + ", valid=" + valid + ", start=" + start + ", rowsperpage="
				+ rowsperpage + "]";
	}


}
