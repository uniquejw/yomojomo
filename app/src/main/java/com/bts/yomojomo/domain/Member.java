package com.bts.yomojomo.domain;

public class Member {
  int no;
  String name;
  String pwd;
  String email;
  String tel;
  String postno;
  String baseaddr;
  String addr;
  String type;
  boolean unsubscribe;

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", tel="
        + tel + ", postno=" + postno + ", baseaddr=" + baseaddr + ", addr=" + addr + ", type="
        + type + ", unsubscribe=" + unsubscribe + "]";
  }

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

  public boolean isUnsubscribe() {
    return unsubscribe;
  }

  public void setUnsubscribe(boolean unsubscribe) {
    this.unsubscribe = unsubscribe;
  }


}