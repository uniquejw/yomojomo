package com.bts.yomojomo.domain;

import lombok.Data;

@Data
public class MyPage {
  int no;
  String name;
  String email;
  String tel;
  String baseAddr;
  String addr;
  String roadNameAddr;


  ActiveLocal activeLocal;
}
