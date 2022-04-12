package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApplyForm {
  int no;
  int groupNo;
  int memberNo;
  String content;
  Date date;

}
