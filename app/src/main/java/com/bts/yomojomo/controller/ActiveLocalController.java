package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.service.ActiveLocalService;


//->요청 파라미터 분석 및 가공
//-> 응답 데이터 가공 
@RestController
public class ActiveLocalController {

  @Autowired
  ActiveLocalService activeLocalService ;

  @RequestMapping("/activeLocal/list")
  public Object list() {
    return activeLocalService.list(); 
  }
  @RequestMapping("/activeLocal/get")
  public Object get(int no) {
    return activeLocalService.get(no);
  }

  @RequestMapping("/activeLocal/list-gu")
  public Object list(String nameGu) {
    return activeLocalService.list(nameGu);
  }


}
