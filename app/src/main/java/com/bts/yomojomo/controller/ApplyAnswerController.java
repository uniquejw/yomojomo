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
    //    List<String> list = new ArrayList<String>();
    //    String[] answers = applyAnswer.getAnswer().split(",");
    //    for (int i = 0; i < answers.length; i++) {
    //      list.add(answers[i]);
    //    };// asList??
    //    int no = applyAnswer.getApplyNo();
    //    System.out.println(list);
    //    System.out.println(no);
    System.out.println(applyAnswer);
    return new ResultMap().setStatus(SUCCESS).setData(applyAnswerService.add(applyAnswer));
  }

  //  public static List<String> getStringListValue(Object obj) throws Exception {
  //    if(obj == null){
  //    return null;
  //    }
  //    ObjectMapper objectMapper = new ObjectMapper();
  //    return objectMapper.readValue((String) obj, List.class);
  //    }

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
