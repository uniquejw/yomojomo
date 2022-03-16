package com.bts.yomojomo.domain;

import java.sql.Date;

public class NoticeQuestion {
  int no;
  int mcate2No;
  int queryNo;
  int membNo;
  String title;
  String content;
  String path;
  Date querydt;
  String answer;
  Date anserdt;


  @Override
  public String toString() {
    return "NoticeQuestion [no=" + no + ", mcate2No=" + mcate2No + ", queryNo=" + queryNo
        + ", membNo=" + membNo + ", title=" + title + ", content=" + content + ", path=" + path
        + ", querydt=" + querydt + ", answer=" + answer + ", anserdt=" + anserdt + "]";
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
  public int getQueryNo() {
    return queryNo;
  }
  public void setQueryNo(int queryNo) {
    this.queryNo = queryNo;
  }
  public int getMembNo() {
    return membNo;
  }
  public void setMembNo(int membNo) {
    this.membNo = membNo;
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
  public Date getQuerydt() {
    return querydt;
  }
  public void setQuerydt(Date querydt) {
    this.querydt = querydt;
  }
  public String getAnswer() {
    return answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  public Date getAnserdt() {
    return anserdt;
  }
  public void setAnserdt(Date anserdt) {
    this.anserdt = anserdt;
  }


}
