package com.bts.yomojomo.domain;

import java.sql.Date;

public class FAQ {
  int no;
  int mcate2no;
  int queryno;
  String title;
  String content;
  String path;
  Date appdt;

  @Override
  public String toString() {
    return "FAQ [no=" + no + ", mcate2no=" + mcate2no + ", queryno=" + queryno + ", title=" + title
        + ", content=" + content + ", path=" + path + ", appdt=" + appdt + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getMcate2no() {
    return mcate2no;
  }

  public void setMcate2no(int mcate2no) {
    this.mcate2no = mcate2no;
  }

  public int getQueryno() {
    return queryno;
  }

  public void setQueryno(int queryno) {
    this.queryno = queryno;
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

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Date getAppdt() {
    return appdt;
  }

  public void setAppdt(Date appdt) {
    this.appdt = appdt;
  }
}
