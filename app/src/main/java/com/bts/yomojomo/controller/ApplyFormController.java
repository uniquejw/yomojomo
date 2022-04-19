package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.ApplyForm;
import com.bts.yomojomo.service.ApplyFormService;

@RestController
public class ApplyFormController {
  @Autowired
  ApplyFormService applyFormService;

  @RequestMapping("/applyform/findQuestion")
  public Object findQuestion(int no) {
    List<ApplyForm> applyForm= applyFormService.findQuestion(no);
    if (applyForm == null) {
      return new ResultMap().setStatus(FAIL).setData("해당되는 신청서가 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(applyForm); 
  }

  @RequestMapping("/applayform/add")
  public Object add(ApplyForm applayForm) {
    return applyFormService.add(applayForm);
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
