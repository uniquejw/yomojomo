package com.bts.yomojomo.domain;

import java.sql.Date;

public class NoticeQuestion {
  int no;
  int mcate2no;
  int queryno;
  int membno;
  String title;
  String content;
  String path;
  Date querydt;
  String answer;
  Date answerdt;


  @Override
  public String toString() {
    return "NoticeQuestion [no=" + no + ", mcate2no=" + mcate2no + ", queryno=" + queryno
        + ", membno=" + membno + ", title=" + title + ", content=" + content + ", path=" + path
        + ", querydt=" + querydt + ", answer=" + answer + ", answerdt=" + answerdt + "]";
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
  public int getMembno() {
    return membno;
  }
  public void setMembno(int membno) {
    this.membno = membno;
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
  public Date getAnswerdt() {
    return answerdt;
  }
  public void setAnswerdt(Date answerdt) {
    this.answerdt = answerdt;
  }


}
