package com.bts.yomojomo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApplyAnswer {
  int no; // appl_answer_no 질문목록답변
  String answer;
  int applyQuestionNo; // appl_question_no 가입신청서 질문목록 번호 
}
