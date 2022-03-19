package com.bts.yomojomo.domain;

public class ApplayForm {
  int no;
  int gno;
  int membno;
  String content;

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
  @Override
  public String toString() {
    return "ApplayForm [no=" + no + ", gno=" + gno + ", membno=" + membno + ", content=" + content
        + "]";
  }
}
