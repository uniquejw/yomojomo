package com.bts.yomojomo.domain;

public class JoinMember {
  int no;
  int gno;
  int gradeno;
  
  @Override
  public String toString() {
    return "JoinMember [no=" + no + ", gno=" + gno + ", gradeno=" + gradeno + "]";
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
  public int getGradeno() {
    return gradeno;
  }
  public void setGradeno(int gradeno) {
    this.gradeno = gradeno;
  }
  
 
  

}
