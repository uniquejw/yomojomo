package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Calendar {
  int no;
  String name;
  String content;
  int gno;
  String resulturl;
  Date startDt;
  Date endDt;
}
