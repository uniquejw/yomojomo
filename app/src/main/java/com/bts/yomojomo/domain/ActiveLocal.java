package com.bts.yomojomo.domain;

public class ActiveLocal {
  int no;
  String name;

  @Override
  public String toString() {
    return "ActiveLocal [no=" + no + ", name=" + name + "]";
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
}
