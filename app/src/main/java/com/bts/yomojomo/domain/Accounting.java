package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Accounting {
  int no;       //act_no
  String title;
  int amount;
  int status;
  Date registDate; //reg_dt
  AccountingCate actCate;
  Group group;
}
