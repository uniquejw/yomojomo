package com.bts.yomojomo.domain;

import java.sql.Date;

public class Group {
  int no;
  int itrlocalno;
  int fileno;
  String name;
  Date cdate;
  String logo;
  String intro;
  int mcnt;
  int fee;
  int vcnt;
  
  
  @Override
  public String toString() {
    return "Group [no=" + no + ", itrlocalno=" + itrlocalno + ", fileno=" + fileno + ", name="
        + name + ", cdate=" + cdate + ", logo=" + logo + ", intro=" + intro + ", mcnt=" + mcnt
        + ", fee=" + fee + ", vcnt=" + vcnt + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getItrlocalno() {
    return itrlocalno;
  }
  public void setItrlocalno(int itrlocalno) {
    this.itrlocalno = itrlocalno;
  }
  public int getFileno() {
    return fileno;
  }
  public void setFileno(int fileno) {
    this.fileno = fileno;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Date getCdate() {
    return cdate;
  }
  public void setCdate(Date cdate) {
    this.cdate = cdate;
  }
  public String getLogo() {
    return logo;
  }
  public void setLogo(String logo) {
    this.logo = logo;
  }
  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public int getMcnt() {
    return mcnt;
  }
  public void setMcnt(int mcnt) {
    this.mcnt = mcnt;
  }
  public int getFee() {
    return fee;
  }
  public void setFee(int fee) {
    this.fee = fee;
  }
  public int getVcnt() {
    return vcnt;
  }
  public void setVcnt(int vcnt) {
    this.vcnt = vcnt;
  }
  
 

  
  
}
