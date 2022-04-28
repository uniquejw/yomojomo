package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.MyPage;
import com.bts.yomojomo.service.MyPageService;

@RestController
public class MyPageController {

  @Autowired
  MyPageService myPageService;

  @RequestMapping("/mypage/list")
  public Object list() {
    return myPageService.list();
  }

  @RequestMapping("/mypage/get")
  public Object get(int no) {
    return myPageService.get(no);
  }

  @RequestMapping("/mypage/update")
  public Object update(MyPage mypage, String email) {
    return myPageService.update(mypage, email);
  }
}
