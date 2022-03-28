package com.bts.yomojomo.domain;
//경현 
import java.sql.Date;

public class Recruit {
  int no;
  String title;
  String content;
  Date date;
  int viewCnt;
  int actLocalNo; //활동지역번호
  int purposeNo; //모임목적번호
  int membNo; //회원번호
  String name;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public int getViewCnt() {
    return viewCnt;
  }
  public void setViewCnt(int viewCnt) {
    this.viewCnt = viewCnt;
  }
  public int getActLocalNo() {
    return actLocalNo;
  }
  public void setActLocalNo(int actLocalNo) {
    this.actLocalNo = actLocalNo;
  }
  public int getPurposeNo() {
    return purposeNo;
  }
  public void setPurposeNo(int purposeNo) {
    this.purposeNo = purposeNo;
  }
  public int getMembNo() {
    return membNo;
  }
  public void setMembNo(int membNo) {
    this.membNo = membNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return "Recruit [no=" + no + ", title=" + title + ", content=" + content + ", date=" + date
        + ", viewCnt=" + viewCnt + ", actLocalNo=" + actLocalNo + ", purposeNo=" + purposeNo
        + ", membNo=" + membNo + ", name=" + name + "]";
  }




}