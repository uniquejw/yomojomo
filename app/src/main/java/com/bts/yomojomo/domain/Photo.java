package com.bts.yomojomo.domain;

public class Photo {
  int no;
  int bno;
  String path;


  @Override
  public String toString() {
    return "Photo [no=" + no + ", bno=" + bno + ", path=" + path + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getBno() {
    return bno;
  }
  public void setBno(int bno) {
    this.bno = bno;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }

}
