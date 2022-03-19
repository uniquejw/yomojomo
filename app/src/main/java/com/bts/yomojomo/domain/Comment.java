package com.bts.yomojomo.domain;

import java.sql.Date;

public class Comment {
  int no;
  int bno;
  String content;
  int membno;
  int gno;
  Date regdt;

  @Override
  public String toString() {
    return "Comment [no=" + no + ", bno=" + bno + ", content=" + content + ", membno=" + membno
        + ", gno=" + gno + ", regdt=" + regdt + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getBno() {
    return bno;
  }

  public void setBno(int bno) {
    this.bno = bno;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getMembno() {
    return membno;
  }

  public void setMembno(int membno) {
    this.membno = membno;
  }

  public int getGno() {
    return gno;
  }

  public void setGno(int gno) {
    this.gno = gno;
  }

  public Date getRegdt() {
    return regdt;
  }

  public void setRegdt(Date regdt) {
    this.regdt = regdt;
  }
}
