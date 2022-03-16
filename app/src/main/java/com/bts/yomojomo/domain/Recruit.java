package com.bts.yomojomo.domain;

import java.sql.Date;

public class Recruit {
  int no;
  String title;
  String content;
  Date reddt;
  int viewCnt;
  int itrLocalNo;
  int fileNo;
  int membNo;
  @Override
  public String toString() {
    return "Recruit [no=" + no + ", title=" + title + ", content=" + content + ", reddt=" + reddt
        + ", viewCnt=" + viewCnt + ", itrLocalNo=" + itrLocalNo + ", fileNo=" + fileNo + ", membNo="
        + membNo + "]";
  }
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
  public Date getReddt() {
    return reddt;
  }
  public void setReddt(Date reddt) {
    this.reddt = reddt;
  }
  public int getViewCnt() {
    return viewCnt;
  }
  public void setViewCnt(int viewCnt) {
    this.viewCnt = viewCnt;
  }
  public int getItrLocalNo() {
    return itrLocalNo;
  }
  public void setItrLocalNo(int itrLocalNo) {
    this.itrLocalNo = itrLocalNo;
  }
  public int getFileNo() {
    return fileNo;
  }
  public void setFileNo(int fileNo) {
    this.fileNo = fileNo;
  }
  public int getMembNo() {
    return membNo;
  }
  public void setMembNo(int membNo) {
    this.membNo = membNo;
  }


}
