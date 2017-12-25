package vo;

// for analysis only, no need to use in web
public class Analysis{
	int startyear;
	int endyear;
	int startmonth;
	int endmonth;
	int startday;
	int endday;
	int pid;
	
	public int getStartyear() {
		return startyear;
	}

	public void setStartyear(int startyear) {
		this.startyear = startyear;
	}

	public int getEndyear() {
		return endyear;
	}

	public void setEndyear(int endyear) {
		this.endyear = endyear;
	}

	public int getStartmonth() {
		return startmonth;
	}

	public void setStartmonth(int startmonth) {
		this.startmonth = startmonth;
	}

	public int getEndmonth() {
		return endmonth;
	}

	public void setEndmonth(int endmonth) {
		this.endmonth = endmonth;
	}

	public int getStartday() {
		return startday;
	}

	public void setStartday(int startday) {
		this.startday = startday;
	}

	public int getEndday() {
		return endday;
	}

	public void setEndday(int endday) {
		this.endday = endday;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Analysis [startyear=" + startyear + ", endyear=" + endyear + ", startmonth=" + startmonth
				+ ", endmonth=" + endmonth + ", startday=" + startday + ", endday=" + endday + ", pid=" + pid + "]";
	}




}
