package com.bts.yomojomo.domain;

import java.sql.Date;

public class Member {
  int no; //memb_no
  String name;
  String pwd;
  String email;
  String tel;
  String postno;
  String baseaddr;
  String addr;
  String type;
  int unsubscribe;
  int status;
  Date stopDt;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getPostno() {
    return postno;
  }
  public void setPostno(String postno) {
    this.postno = postno;
  }
  public String getBaseaddr() {
    return baseaddr;
  }
  public void setBaseaddr(String baseaddr) {
    this.baseaddr = baseaddr;
  }
  public String getAddr() {
    return addr;
  }
  public void setAddr(String addr) {
    this.addr = addr;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public int getUnsubscribe() {
    return unsubscribe;
  }
  public void setUnsubscribe(int unsubscribe) {
    this.unsubscribe = unsubscribe;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public Date getStopDt() {
    return stopDt;
  }
  public void setStopDt(Date stopDt) {
    this.stopDt = stopDt;
  }

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", tel="
        + tel + ", postno=" + postno + ", baseaddr=" + baseaddr + ", addr=" + addr + ", type="
        + type + ", unsubscribe=" + unsubscribe + ", status=" + status + ", stopDt=" + stopDt + "]";
  }
}
