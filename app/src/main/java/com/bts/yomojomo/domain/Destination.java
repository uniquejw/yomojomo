package com.bts.yomojomo.domain;

import java.sql.Date;

public class Destination {
 int no;
 String flat;
 String flng;
 String storeName;
 String locationId;
 Date regdt;
 int cnt;
 
 
@Override
public String toString() {
  return "Destination [no=" + no + ", flat=" + flat + ", flng=" + flng + ", storeName=" + storeName
      + ", locationId=" + locationId + ", regdt=" + regdt + ", cnt=" + cnt + "]";
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
public String getStoreName() {
  return storeName;
}
public void setStoreName(String storeName) {
  this.storeName = storeName;
}
public String getLocationId() {
  return locationId;
}
public void setLocationId(String locationId) {
  this.locationId = locationId;
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
