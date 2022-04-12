package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.ApplyQuestion;

public interface ApplyQuestionService {

  int add(ApplyQuestion applyQuestion);

  List<ApplyQuestion> list();
  //
  //  ApplyQuestion get(int no);
  //
  //  int update(ApplyQuestion applyQuestion);
  //
  //  int delete(int no);

}
