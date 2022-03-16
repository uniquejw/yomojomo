package com.bts.yomojomo.domain;

public class Calendar {
  int no;
  String name;
  String content;
  int gno;
  String resulturl;

  @Override
  public String toString() {
    return "Calendar [no=" + no + ", name=" + name + ", content=" + content + ", gno=" + gno
        + ", resulturl=" + resulturl + "]";
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
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getGno() {
    return gno;
  }
  public void setGno(int gno) {
    this.gno = gno;
  }
  public String getResulturl() {
    return resulturl;
  }
  public void setResulturl(String resulturl) {
    this.resulturl = resulturl;
  }
}
