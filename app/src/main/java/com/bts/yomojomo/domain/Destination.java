package com.bts.yomojomo.domain;

import java.sql.Date;

public class Destination {
  int no;
  String flat;
  String flng;
  String storename;
  String locationid;
  Date regdt;
  int cnt;
  
@Override
public String toString() {
	return "Destination [no=" + no + ", flat=" + flat + ", flng=" + flng + ", storename=" + storename + ", locationid="
			+ locationid + ", regdt=" + regdt + ", cnt=" + cnt + "]";
}

public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getFlat() {
	return flat;
}
public void setFlat(String flat) {
	this.flat = flat;
}
public String getFlng() {
	return flng;
}
public void setFlng(String flng) {
	this.flng = flng;
}
public String getStorename() {
	return storename;
}
public void setStorename(String storename) {
	this.storename = storename;
}
public String getLocationid() {
	return locationid;
}
public void setLocationid(String locationid) {
	this.locationid = locationid;
}
public Date getRegdt() {
	return regdt;
}
public void setRegdt(Date regdt) {
	this.regdt = regdt;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
  
}