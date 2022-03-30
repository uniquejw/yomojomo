package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Member {
  int no; //memb_no
  String membName;
  String pwd;
  String email;
  String tel;
  String postno;
  String baseaddr;
  String addr;
  String type;
  int unsubscribe;
  int status;
  Date stopDt;
}
