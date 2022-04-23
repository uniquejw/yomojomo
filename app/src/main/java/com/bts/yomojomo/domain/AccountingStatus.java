package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountingStatus {
  int accountingNo; //모금번호
  int gNo; //모임번호
  int membNo; //회원번호
  Date paydt; //납부일
  //  Group group;
  //  Member member;

  public AccountingStatus() {}

  public AccountingStatus(int gNo, int membNo, Date paydt) {
    this.gNo = gNo;
    this.membNo = membNo;
    this.paydt = paydt;
  }
}
