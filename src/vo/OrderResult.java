package vo;

public class OrderResult {
	String id;
	String status;
	String sourceid;
	String senderid;
	String senddate;
	String requesterid;
	String wishdate;
	String pid;
	int istransfer;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSourceid() {
		return sourceid;
	}
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
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

	public int getIstransfer() {
		return istransfer;
	}
	public void setIstransfer(int istransfer) {
		this.istransfer = istransfer;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "OrderResult [id=" + id + ", status=" + status + ", sourceid=" + sourceid + ", senderid=" + senderid
				+ ", senddate=" + senddate + ", requesterid=" + requesterid + ", wishdate=" + wishdate + ", pid=" + pid
				+ ", istransfer=" + istransfer + "]";
	}


	
}
