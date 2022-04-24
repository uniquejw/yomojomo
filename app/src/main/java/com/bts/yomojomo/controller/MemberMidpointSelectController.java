package com.bts.yomojomo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Accounting;
import com.bts.yomojomo.domain.MemberMidpointSelect;
import com.bts.yomojomo.service.MemberMidpointSelectService;

@RestController
public class MemberMidpointSelectController {

  private static final Logger log = LoggerFactory.getLogger(Accounting.class);

  @Autowired 
  MemberMidpointSelectService memberMidpointSelectService;

  @RequestMapping("/midpoint/member/list")
  public Object list(MemberMidpointSelect memberMidpointSelect) {
    return memberMidpointSelectService.memberListByGroupAndCalendar(memberMidpointSelect);
  }


}