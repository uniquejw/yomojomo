package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Notice {
  int no;
  int mainCategoryNo;
  String cate;
  String title;
  String content;
  Date regDate;

}
