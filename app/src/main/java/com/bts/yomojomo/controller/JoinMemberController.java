package com.bts.yomojomo.controller;


import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
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

  @RequestMapping("/joinmember/listbygradeno") //경현 - 수정시 말해주세요
  //회원 등급으로 모임번호, 모임이름, 회원번호, 회원이름, 모임등급번호, 모임등급이름 검색
  //test : http://localhost:8080/joinmember/listbygradeno?memberGrade.gradeNo=회원등급번호(1또는2)
  public Object listbyGradeNo(JoinMember joinMember) {
    return joinMemberservice.listbyGradeNo(joinMember);
  }

  @RequestMapping("/joinmember/grouplistbymno") //경현 - 수정시 말해주세요
  //회원 등급으로 모임번호, 모임이름, 회원번호, 회원이름, 모임등급번호, 모임등급이름 검색
  //test : http://localhost:8080/joinmember/grouplistbymno?member.no=회원번호
  public Object grouplistByMno(JoinMember joinMember, HttpSession session) {
    return new ResultMap().setStatus(SUCCESS).setData(joinMemberservice.grouplistByMno(joinMember));
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