package com.bts.yomojomo.domain;

import java.sql.Date;

public class Notice {
  int no;
  int mcate2No;
  String cate;
  String title;
  String content;
  Date dt;


  @Override
  public String toString() {
    return "Notice [no=" + no + ", mcate2No=" + mcate2No + ", cate=" + cate + ", title=" + title
        + ", content=" + content + ", dt=" + dt + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getMcate2No() {
    return mcate2No;
  }
  public void setMcate2No(int mcate2No) {
    this.mcate2No = mcate2No;
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
  public Date getDt() {
    return dt;
  }
  public void setDt(Date dt) {
    this.dt = dt;
  }

}
