package vo;

public class OrderDetailResult {
	String oid;
	String iid;
	String _iid;
	int ordnum;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public int getOrdnum() {
		return ordnum;
	}
	public void setOrdnum(int ordnum) {
		this.ordnum = ordnum;
	}
	public String get_iid() {
		return _iid;
	}
	public void set_iid(String _iid) {
		this._iid = _iid;
	}
	@Override
	public String toString() {
		return "OrderDetailResult [oid=" + oid + ", iid=" + iid + ", _iid=" + _iid + ", ordnum=" + ordnum + "]";
	}

	
}
