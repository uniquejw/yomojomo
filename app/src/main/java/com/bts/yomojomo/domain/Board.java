package com.bts.yomojomo.domain;

import java.sql.Date;

public class Board {
  int no;
  int gno;
  int membno;
  Date regdt;
  String content;
  int viewcnt;
  boolean status;

  @Override
  public String toString() {
    return "Board [no=" + no + ", gno=" + gno + ", membno=" + membno + ", regdt=" + regdt
        + ", content=" + content + ", viewcnt=" + viewcnt + ", status=" + status + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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

  public Date getRegdt() {
    return regdt;
  }

  public void setRegdt(Date regdt) {
    this.regdt = regdt;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getViewcnt() {
    return viewcnt;
  }

  public void setViewcnt(int viewcnt) {
    this.viewcnt = viewcnt;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
