package com.bts.yomojomo.domain;

import java.util.List;
import lombok.Data;

@Data
public class MyPage {
  int no;
  String name;
  String pwd;
  String email;
  String tel;
  String postNo;
  String baseAddr;
  String addr;
  String roadNameAddr;

  List <FinalActiveLocal> finalActiveLocal;
  List <FinalPurpose> finalPurpose;
  List <ActiveLocal> activeLocal;
  List <Purpose> purpose;
}
