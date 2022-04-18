package com.bts.yomojomo.controller;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.ApplyAnswer;
import com.bts.yomojomo.service.ApplyAnswerService;

@RestController
public class ApplyAnswerController {
  @Autowired
  ApplyAnswerService applyAnswerService;

  @RequestMapping("/applyAnswer/add")
  public Object add(ApplyAnswer applyAnswer) {
    System.out.println(applyAnswer);
    return new ResultMap().setStatus(SUCCESS).setData(applyAnswerService.add(applyAnswer));
  }

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
