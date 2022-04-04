package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Accounting {
  int no;       //act_no
  int gno;      //g_no
  int actcateno;
  String title;
  int amount;
  int status;
  Date date; //reg_dt
  AccountingCate actCate;
  Group group;
}
