package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Board {
  int no;
  int gno;
  int membno;
  Date regdt;
  String content;
  int viewcnt;
  boolean status;

}
