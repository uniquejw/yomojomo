package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class AccountingStatus {
  int actNo; //모금번호
  int gNo; //모임번호
  int membNo; //회원번호
  Date paydt;
}
