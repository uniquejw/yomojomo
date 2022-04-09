package com.bts.yomojomo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.JoinMember;
import com.bts.yomojomo.service.JoinMemberService;


@RestController
public class JoinMemberController {

  private static final Logger log = LoggerFactory.getLogger(JoinMemberController.class);

  @Autowired 
  JoinMemberService joinMemberservice;

  @RequestMapping("/joinmember/list")
  public Object list() {

    return joinMemberservice.list();
  }

  @RequestMapping("/joinmember/gradenolist") //경현 - 수정시 말해주세요
  public Object gradenolist(int no) {
    return joinMemberservice.findByGradeNo(no);
  }




  @RequestMapping("/joinmember/get")
  public Object get(int no) {
    JoinMember joinMember = joinMemberservice.get(no);
    if (joinMember == null) {
      return "";
    }
    return joinMember;
  }

  @RequestMapping("/joinmember/add")
  public int add(JoinMember joinMember) {
    return joinMemberservice.add(joinMember);
  }

  @RequestMapping("/joinmember/update")
  public int update(JoinMember joinMember) {
    return joinMemberservice.update(joinMember);
  }

  @RequestMapping("/joinmember/delete")
  public Object delete(int no) {
    return joinMemberservice.delete(no);
  }
}