package com.bts.yomojomo.domain;

import java.sql.Date;
import java.util.List;
import lombok.Data;

//필드명 교체시 저한테 말해주세요 - 경현

@Data
public class Recruit {
  int no;
  String title;
  String content;
  Date date;
  int viewCnt;
  int actLocalNo; //활동지역번호
  int purposeNo; //모임목적번호
  int membNo; //회원번호
  List<Member> member;
  List<ActiveLocal> activeLocal;
  List<Purpose> purpose;
}