package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.ApplyQuestion;
import com.bts.yomojomo.service.ApplyQuestionService;

@RestController
public class ApplyQuestionController {
  @Autowired
  ApplyQuestionService applyQuestionService;

  @RequestMapping("/applayQuestion/add")
  public Object add(ApplyQuestion applayForm) {
    return applyQuestionService.add(applayForm);
  }
  //
  //  @RequestMapping("/applayQuestion/get")
  //  public Object get(int no) {
  //    ApplyQuestion applyQuestion = applyQuestionService.get(no);
  //    if (applyQuestion == null) {
  //      return new ResultMap().setStatus(FAIL).setData("해당번호의 신청서가 없습니다.");
  //    }
  //    return new ResultMap().setStatus(SUCCESS).setData(applyQuestion);
  //  }

  @RequestMapping("/applayQuestion/list")
  public Object list() {
    return applyQuestionService.list(); 
  }
  //
  //  @RequestMapping("/applayQuestion/update")
  //  public Object update(ApplyQuestion applayForm) {
  //    return applyQuestionService.update(applayForm);
  //  }
  //
  //  @RequestMapping("/applayQuestion/delete")
  //  public Object delete(int no) {
  //    return applyQuestionService.delete(no);
  //  }
}