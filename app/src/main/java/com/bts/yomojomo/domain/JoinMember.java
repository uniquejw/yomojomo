package com.bts.yomojomo.domain;

public class JoinMember {
  int no;
  int gNo;
  int gMembGrdNo;
  @Override
  public String toString() {
    return "JoinMember [no=" + no + ", gNo=" + gNo + ", gMembGrdNo=" + gMembGrdNo + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getgNo() {
    return gNo;
  }
  public void setgNo(int gNo) {
    this.gNo = gNo;
  }
  public int getgMembGrdNo() {
    return gMembGrdNo;
  }
  public void setgMembGrdNo(int gMembGrdNo) {
    this.gMembGrdNo = gMembGrdNo;
  }





}
