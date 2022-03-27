package com.bts.yomojomo.domain;

import java.sql.Date;

public class FAQ {
  int no;
  int maincateno;
  int queryno;
  String title;
  String content;
  String path;
  Date regdt;

  @Override
  public String toString() {
    return "FAQ [no=" + no + ", maincateno=" + maincateno + ", queryno=" + queryno + ", title="
        + title + ", content=" + content + ", path=" + path + ", regdt=" + regdt + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getMaincateno() {
    return maincateno;
  }

  public void setMaincateno(int maincateno) {
    this.maincateno = maincateno;
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

  public Date getRegdt() {
    return regdt;
  }

  public void setRegdt(Date regdt) {
    this.regdt = regdt;
  }
}
