package com.java.util.model;

public class shop {

	String uname;
	int pid;
	String pname;
	int q;
	int perunitrate;
	int price;
	int totalprice;
	public int getPerunitrate() {
		return perunitrate;
	}
	public void setPerunitrate(int perunitrate) {
		this.perunitrate = perunitrate;
	}
 
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuantity() {
		return q;
	}
	public void setQuantity(int q) {
		this.q = q;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "shop [pid=" + pid + ", pname=" + pname + ", quantity=" + q + ", price=" + price + ", totalprice="
				+ totalprice + "]";
	}
	
   
}

