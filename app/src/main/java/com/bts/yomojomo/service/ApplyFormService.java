package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.ApplyForm;

public interface ApplyFormService {

  List<ApplyForm> findQuestion(int no);
  int add(ApplyForm applyForm);
  //
  //  List<ApplyForm> list();
  //
  //  ApplyForm get(int no);
  //
  //  int update(ApplyForm applyForm);
  //
  //  int delete(int no);

}
