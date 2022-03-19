package com.bts.yomojomo.domain;

public class Keyword {
  int kno;
  String searchname;
  int membno;
  
  @Override
  public String toString() {
    return "Keyword [kno=" + kno + ", searchname=" + searchname + ", membno=" + membno + "]";
  }
  public int getKno() {
    return kno;
  }
  public void setKno(int kno) {
    this.kno = kno;
  }
  public String getSearchname() {
    return searchname;
  }
  public void setSearchname(String searchname) {
    this.searchname = searchname;
  }
  public int getMembno() {
    return membno;
  }
  public void setMembno(int membno) {
    this.membno = membno;
  }
  
  
  

}
