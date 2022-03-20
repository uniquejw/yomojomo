package com.bts.yomojomo.domain;

import java.sql.Date;

public class Group {
  int no;
  int actlocalno;
  int pupsno;
  String name;
  Date regdt;
  String logo;
  String intro;
  int maxcnt;
  int fee;
  int viewcnt;
  
  
  
@Override
public String toString() {
	return "Group [no=" + no + ", actlocalno=" + actlocalno + ", pupsno=" + pupsno + ", name=" + name + ", regdt="
			+ regdt + ", logo=" + logo + ", intro=" + intro + ", maxcnt=" + maxcnt + ", fee=" + fee + ", viewcnt="
			+ viewcnt + "]";
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public int getActlocalno() {
	return actlocalno;
}
public void setActlocalno(int actlocalno) {
	this.actlocalno = actlocalno;
}
public int getPupsno() {
	return pupsno;
}
public void setPupsno(int pupsno) {
	this.pupsno = pupsno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getRegdt() {
	return regdt;
}
public void setRegdt(Date regdt) {
	this.regdt = regdt;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public int getMaxcnt() {
	return maxcnt;
}
public void setMaxcnt(int maxcnt) {
	this.maxcnt = maxcnt;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
public int getViewcnt() {
	return viewcnt;
}
public void setViewcnt(int viewcnt) {
	this.viewcnt = viewcnt;
}
  
  
 
  
}
