package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.ApplyAnswer;

public interface ApplyAnswerService {

  int add(ApplyAnswer applyAnswer);

  List<ApplyAnswer> list();

  //  ApplyAnswer get(int no);
  //
  //  int update(ApplyAnswer applyAnswer);
  //
  //  int delete(int no);

}
