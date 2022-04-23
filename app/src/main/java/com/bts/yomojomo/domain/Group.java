package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Group {
  int no;           //g_no
  int activeLocalNo;   //act_local_no
  int purposeNo;       //pups_no
  String GroupName;      //name
  Date registDate;       //reg_dt
  String logo;      //logo
  String intro;     //intro
  int memberCount;//memb_cnt
  int maxCount;       //max_cnt
  int viewCount;      //view_cnt
  int status;       //status
  int stopDate;       //stop_dt
  ActiveLocal activeLocal;
  Purpose purpose;
}
