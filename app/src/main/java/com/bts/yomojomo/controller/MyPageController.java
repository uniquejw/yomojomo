package com.bts.yomojomo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.FinalActiveLocal;
import com.bts.yomojomo.domain.FinalPurpose;
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
  public Object update(MyPage mypage) {
    return myPageService.update(mypage);
  }

  @RequestMapping("/mypage/deleteCategory")
  public Object deleteCategory(MyPage mypage) {
    return myPageService.deleteCategory(mypage);
  }

  @RequestMapping("/mypage/insertCategory")
  public Object insertCategory(MyPage mypage, String[] localArr, String[] purposeArr) throws Exception {
    System.out.println(localArr[0]);
    ArrayList<FinalActiveLocal> locallist = new ArrayList<>();
    for (int i = 0; i < localArr.length; i++) {
      String value = localArr[i];
      FinalActiveLocal finalactivelocal = new FinalActiveLocal(Integer.parseInt(value));
      locallist.add(finalactivelocal);
    }

    ArrayList<FinalPurpose> purposelist = new ArrayList<>();
    for (int i = 0; i < purposeArr.length; i++) {
      String value = purposeArr[i];
      FinalPurpose finalpurpose = new FinalPurpose(Integer.parseInt(value));
      purposelist.add(finalpurpose);
    }
    mypage.setFinalActiveLocal(locallist);
    mypage.setFinalPurpose(purposelist);

    return myPageService.insertCategory(mypage);
  }
}
