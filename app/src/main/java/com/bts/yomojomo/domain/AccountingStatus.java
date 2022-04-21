package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountingStatus {
  int actNo; //모금번호
  int gNo; //모임번호
  int membNo; //회원번호
  Date paydt; //납부일

  public AccountingStatus() {}

  public AccountingStatus(int gNo, int membNo, Date paydt) {
    this.actNo = actNo;
    this.gNo = gNo;
    this.membNo = membNo;
    this.paydt = paydt;
  }
}
