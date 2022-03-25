package com.bts.yomojomo.domain;

public class ActiveLocal {
  int no; //act_local_no
  String purposeName;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getPurposeName() {
    return purposeName;
  }
  public void setPurposeName(String purposeName) {
    this.purposeName = purposeName;
  }
  
  @Override
  public String toString() {
    return "ActiveLocal [no=" + no + ", purposeName=" + purposeName + "]";
  }


}
