package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.ApplyAnswer;
import com.bts.yomojomo.service.ApplyAnswerService;

@RestController
public class ApplyAnswerController {
  @Autowired
  ApplyAnswerService applyAnswerService;

  @RequestMapping("/applayAnswer/add")
  public Object add(ApplyAnswer applyAnswer) {
    return applyAnswerService.add(applyAnswer);
  }
  //
  //  @RequestMapping("/applayAnswer/get")
  //  public Object get(int no) {
  //    ApplyAnswer applyAnswer = applyAnswerService.get(no);
  //    if (ApplyAnswer == null) {
  //      return new ResultMap().setStatus(FAIL).setData("해당번호의 신청서가 없습니다.");
  //    }
  //    return new ResultMap().setStatus(SUCCESS).setData(applyAnswer);
  //  }

  @RequestMapping("/applyAnswer/list")
  public Object list() {
    return applyAnswerService.list(); 
  }
  //
  //  @RequestMapping("/applyAnswer/update")
  //  public Object update(ApplyAnswer applyAnswer) {
  //    return applyAnswerService.update(applyAnswer);
  //  }
  //
  //  @RequestMapping("/applyAnswer/delete")
  //  public Object delete(int no) {
  //    return applyAnswerService.delete(no);
  //  }
}
