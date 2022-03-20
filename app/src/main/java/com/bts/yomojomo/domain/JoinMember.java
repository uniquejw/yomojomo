package com.bts.yomojomo.domain;

public class JoinMember {
  int no;
  int gno;
  int gmembgrdno;
  
  
  @Override
  public String toString() {
    return "JoinMember [no=" + no + ", gno=" + gno + ", gmembgrdno=" + gmembgrdno + "]";
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
  public int getGmembgrdno() {
    return gmembgrdno;
  }
  public void setGmembgrdno(int gmembgrdno) {
    this.gmembgrdno = gmembgrdno;
  }
  

}
