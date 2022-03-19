package com.bts.yomojomo.domain;

import java.sql.Date;

public class AccountingStatus {
  int actno; //모금번호
  int gno; //모임번호
  int membno; //회원번호
  Date paydt;


  @Override
  public String toString() {
    return "AccountingStatus [actno=" + actno + ", gno=" + gno + ", membno=" + membno + ", paydt="
        + paydt + "]";
  }
  public int getActno() {
    return actno;
  }
  public void setActno(int actno) {
    this.actno = actno;
  }
  public int getGno() {
    return gno;
  }
  public void setGno(int gno) {
    this.gno = gno;
  }
  public int getMembno() {
    return membno;
  }
  public void setMembno(int membno) {
    this.membno = membno;
  }
  public Date getPaydt() {
    return paydt;
  }
  public void setPaydt(Date paydt) {
    this.paydt = paydt;
  }



}
