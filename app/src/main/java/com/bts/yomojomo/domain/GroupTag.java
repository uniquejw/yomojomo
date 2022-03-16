package com.bts.yomojomo.domain;



public class GroupTag {
  int no;
  int gno;
  String tag;
  
  @Override
  public String toString() {
    return "GroupTag [no=" + no + ", gno=" + gno + ", tag=" + tag + "]";
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
  public String getTag() {
    return tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }


  
  
 

  
  
}
