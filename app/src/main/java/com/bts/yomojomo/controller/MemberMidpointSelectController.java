package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.MemberMidpointSelect;
import com.bts.yomojomo.service.MemberMidpointSelectService;

@RestController
public class MemberMidpointSelectController {



  @Autowired 
  MemberMidpointSelectService memberMidpointSelectService;

  @RequestMapping("/midpoint/member/calendar/list")
  public Object list(MemberMidpointSelect memberMidpointSelect) {
    return memberMidpointSelectService.memberListByGroupAndCalendar(memberMidpointSelect);
  }


}