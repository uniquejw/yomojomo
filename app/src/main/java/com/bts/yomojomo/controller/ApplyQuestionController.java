package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.ApplyQuestion;
import com.bts.yomojomo.service.ApplyQuestionService;

@RestController
public class ApplyQuestionController {
  @Autowired
  ApplyQuestionService applyQuestionService;

  @RequestMapping("/applyQuestion/add")
  public Object add(int no, String[] questionName) {
    ArrayList<ApplyQuestion> questionList = new ArrayList();
    ApplyQuestion applyQuestion = new ApplyQuestion();
    for (int i = 0; i < questionName.length; i++) {
      String value = questionName[i];
      System.out.println(value);
      if (value == null) {
        continue;
      }
      applyQuestion.setQuestionName(value);
      applyQuestion.setGroupNo(no);
      questionList.add(applyQuestion);
      System.out.println(questionList);
    }
    return  new ResultMap().setStatus(SUCCESS).setData(applyQuestionService.add(questionList));  

  }
  //신청서의 질문 목록을 조회
  @RequestMapping("/applyQuestion/findQuestion")
  public Object findQuestion(int no) {
    List<ApplyQuestion> applyquestion= applyQuestionService.findQuestion(no);
    if (applyquestion == null) {
      return new ResultMap().setStatus(FAIL).setData("해당되는 신청서가 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(applyquestion); 
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