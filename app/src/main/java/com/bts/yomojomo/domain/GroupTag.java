package com.bts.yomojomo.domain;

public class GroupTag {
  int no;
  int gno;
  String tagname;
  
  @Override
  public String toString() {
    return "GroupTag [no=" + no + ", gno=" + gno + ", tag_name=" + tagname + "]";
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
  public String getTagname() {
    return tagname;
  }
  public void setTagname(String tagname) {
    this.tagname = tagname;
  }
  
  
 
}
