package com.bts.yomojomo.domain;

import java.sql.Date;

public class Board {
  int no;
  int gno;
  int membno;
  Date dt;
  String content;
  int viewcnt;

  @Override
  public String toString() {
    return "Board [no=" + no + ", gno=" + gno + ", membno=" + membno + ", dt=" + dt + ", content="
        + content + ", viewcnt=" + viewcnt + "]";
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

  public Date getDt() {
    return dt;
  }

  public void setDt(Date dt) {
    this.dt = dt;
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


}
