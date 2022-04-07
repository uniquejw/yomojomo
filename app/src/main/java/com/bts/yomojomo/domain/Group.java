package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

//필드명 카멜표기법으로 변경 주석은 db 컬럼명 - 경현

@Data
public class Group {
  int no;           //g_no
  int activeLocalNo;   //act_local_no
  int purposeNo;       //pups_no
  String GroupName;      //name
  Date registDate;       //reg_dt
  String logo;      //logo
  String intro;     //intro
  int maxCount;       //max_cnt
  int viewCount;      //view_cnt
  int status;       //status
  int stopDate;       //stop_dt
  ActiveLocal activeLocal;
}
