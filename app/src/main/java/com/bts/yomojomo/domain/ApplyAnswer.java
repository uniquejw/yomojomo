package com.bts.yomojomo.domain;

import java.sql.Date;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApplyAnswer {
  int no; // appl_answer_no 질문목록답변
  List<ApplyAnswer> answer;
  int applyNo; // appl_no 가입신청서 질문목록 번호 
  Date applyDate;// appl_dt
  Member writer;
}
