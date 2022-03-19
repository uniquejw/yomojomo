package com.bts.yomojomo.domain;

public class ItrJobGroupDetail {
  int no;
  String name;
  int ijgno;
  
  @Override
  public String toString() {
    return "ItrJobGroupDetail [no=" + no + ", name=" + name + ", ijgno=" + ijgno + "]";
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
  public int getIjgno() {
    return ijgno;
  }
  public void setIjgno(int ijgno) {
    this.ijgno = ijgno;
  }
  
  

}
