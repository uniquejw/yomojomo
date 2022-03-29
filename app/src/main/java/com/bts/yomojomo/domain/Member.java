package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

//필드명 교체시 저한테 말해주세요 - 경현

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
