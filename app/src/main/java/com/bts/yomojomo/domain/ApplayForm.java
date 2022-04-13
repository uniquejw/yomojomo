package com.bts.yomojomo.domain;

import java.sql.Date;

public class ApplayForm {
  int no;
  int gno;
  int membno;
  String content;
  Date date;

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
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "ApplayForm [no=" + no + ", gno=" + gno + ", membno=" + membno + ", content=" + content
        + ", date=" + date + "]";
  }
}
