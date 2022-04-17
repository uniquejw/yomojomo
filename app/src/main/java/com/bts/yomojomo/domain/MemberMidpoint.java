package com.bts.yomojomo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MemberMidpoint {
  int no;
  String lat;
  String lng;

  // 외래키
  Member member;
  Group group;
}
