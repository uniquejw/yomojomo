package com.bts.yomojomo.domain;

import java.sql.Date;
import lombok.Data;

//필드명 교체시 저한테 말해주세요 - 경현

@Data
public class Recruit {
  int no;
  String title;
  String content;
  Date date;
  int viewCnt;
  Member member;
  ActiveLocal activeLocal;
  Purpose purpose;
}