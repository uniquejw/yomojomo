package com.bts.yomojomo.domain;

import java.sql.Date;

public class NoticeQuestion {
  int qNo;
  int mainCateNo;
  int queryNo;
  int membNo;
  String title;
  String content;
  String path;
  Date queryDt;
  String answer;
  Date answerDt;


  @Override
  public String toString() {
    return "NoticeQuestion [qNo=" + qNo + ", mainCateNo=" + mainCateNo + ", queryNo=" + queryNo
        + ", membNo=" + membNo + ", title=" + title + ", content=" + content + ", path=" + path
        + ", queryDt=" + queryDt + ", answer=" + answer + ", answerDt=" + answerDt + "]";
  }
  public int getqNo() {
    return qNo;
  }
  public void setqNo(int qNo) {
    this.qNo = qNo;
  }
  public int getMainCateNo() {
    return mainCateNo;
  }
  public void setMainCateNo(int mainCateNo) {
    this.mainCateNo = mainCateNo;
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
  public Date getQueryDt() {
    return queryDt;
  }
  public void setQueryDt(Date queryDt) {
    this.queryDt = queryDt;
  }
  public String getAnswer() {
    return answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  public Date getAnswerDt() {
    return answerDt;
  }
  public void setAnswerDt(Date answerDt) {
    this.answerDt = answerDt;
  }

}
