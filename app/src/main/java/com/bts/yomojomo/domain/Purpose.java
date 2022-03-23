package com.bts.yomojomo.domain;

public class Purpose {
  int no; //pups_no
  String name;


  @Override
  public String toString() {
    return "Purpose [no=" + no + ", name=" + name + "]";
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
