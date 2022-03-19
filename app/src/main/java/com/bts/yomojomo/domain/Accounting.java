package com.bts.yomojomo.domain;

public class Accounting {
  int no;
  int gno;
  int actcateno;
  String title;
  int amount;
  int status;

  @Override
  public String toString() {
    return "Accounting [no=" + no + ", gno=" + gno + ", actcateno=" + actcateno + ", title=" + title
        + ", amount=" + amount + ", status=" + status + "]";
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

  public int getActcateno() {
    return actcateno;
  }

  public void setActcateno(int actcateno) {
    this.actcateno = actcateno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }



}
