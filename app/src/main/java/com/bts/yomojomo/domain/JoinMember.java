package com.bts.yomojomo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JoinMember {
  int membNo;         //memb_no -> 외래키라 no에서 membNo로 바꿈 여기만 바꿈
  int gNo;              //g_no
  int gMembGrdNo;       //g_memb_grd_no
}
