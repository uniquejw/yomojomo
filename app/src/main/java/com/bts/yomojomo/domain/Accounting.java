package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Accounting {
  int no;       //act_no
  int gno;      //g_no
  int actcateno;
  AccountingCate actCate;
  String title;
  int amount;
  int status;
  Date date; //reg_dt
}
