package com.bts.yomojomo.domain;

import java.sql.Date;

public class Notice {
  int no;
  int mainCateNo;
  String cate;
  String title;
  String content;
  Date regDt;


  @Override
  public String toString() {
    return "Notice [no=" + no + ", mainCateNo=" + mainCateNo + ", cate=" + cate + ", title=" + title
        + ", content=" + content + ", regDt=" + regDt + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getMainCateNo() {
    return mainCateNo;
  }
  public void setMainCateNo(int mainCateNo) {
    this.mainCateNo = mainCateNo;
  }
  public String getCate() {
    return cate;
  }
  public void setCate(String cate) {
    this.cate = cate;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegDt() {
    return regDt;
  }
  public void setRegDt(Date regDt) {
    this.regDt = regDt;
  }

}
