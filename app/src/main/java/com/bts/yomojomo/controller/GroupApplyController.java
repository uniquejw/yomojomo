package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.GroupApplyForm;
import com.bts.yomojomo.service.GroupApplyService;

@RestController
public class GroupApplyController {

  @Autowired
  GroupApplyService groupApplyService;

  @RequestMapping("/group/getmasteruser")
  public Object getmasteruser(GroupApplyForm groupApplyForm) {
    System.out.println(groupApplyForm);
    return groupApplyService.masterUser(groupApplyForm);
  }

}
