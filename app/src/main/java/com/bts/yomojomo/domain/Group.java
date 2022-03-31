package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

//필드명 카멜표기법으로 변경 주석은 db 컬럼명 - 경현

@Data
public class Group {
  int no;           //g_no
  int actlocalNo;   //act_local_no
  int pupsNo;       //pups_no
  String GroupName;      //name
  Date regdt;       //reg_dt
  String logo;      //logo
  String intro;     //intro
  int maxCnt;       //max_cnt
  int fee;          //fee
  int viewCnt;      //view_cnt
  int status;       //status
  int stopDt;       //stop_dt
}
