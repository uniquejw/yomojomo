package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.ApplyForm;
import com.bts.yomojomo.service.ApplyFormService;

@RestController
public class ApplyFormController {
  @Autowired
  ApplyFormService applyFormService;
  //  신청서 생성
  @RequestMapping("/applyForm/add")
  public Object add(ApplyForm applyForm) {
    return new ResultMap().setStatus(SUCCESS).setData(applyFormService.add(applyForm));
  }

  //  신청서에 질문 추가 
  @RequestMapping("/applyQuestion/addQuestion")
  public Object addQuestion(ApplyForm applyForm) {

    return new ResultMap().setStatus(SUCCESS).setData(applyFormService.addQuestion(applyForm));
  }





  //  @RequestMapping("/applyform/get")
  //  public Object get(int no) {
  //    ApplyForm applyForm = applyFormService.get(no);
  //    if (applyForm == null) {
  //      return new ResultMap().setStatus(FAIL).setData("해당번호의 신청서가 없습니다.");
  //    }
  //    return new ResultMap().setStatus(SUCCESS).setData(applyForm);
  //  }
  //  @RequestMapping("/applyform/list")
  //  public Object list() {
  //    return applyFormService.list(); 
  //  }

  //  @RequestMapping("/applyform/update")
  //  public Object update(ApplyForm applayForm) {
  //    return applyFormService.update(applayForm);
  //  }

  //  @RequestMapping("/applyform/delete")
  //  public Object delete(int no) {
  //    return applyFormService.delete(no);
  //  }
}
