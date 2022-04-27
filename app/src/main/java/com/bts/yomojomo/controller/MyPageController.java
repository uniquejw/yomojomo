package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.service.MyPageService;

@RestController
public class MyPageController {

  @Autowired
  MyPageService myPageService;

  String Email = "aaa@naver.com";

  @RequestMapping("/mypage/list")
  public Object list(String email) {
    email = this.Email;
    return myPageService.list(email);
  }
}
