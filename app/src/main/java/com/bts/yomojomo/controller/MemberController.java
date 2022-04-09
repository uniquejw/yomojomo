package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.dto.MemberDto;
import com.bts.yomojomo.service.MemberService;

@RestController
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/signup")
  public Object signUp(Member member) { //경현 : resultMap으로 변환
    if (memberService.add(member) == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL);
    }
  }

  @RequestMapping("/member/signin") 
  public Object signin(String email, String password, HttpSession session) {
    Member loginUser = memberService.get(email, password);
    if (loginUser == null) {

      return new ResultMap().setStatus(FAIL);
    }

    // 로그인이 성공하면,
    // 다른 요청을 처리할 때 로그인 회원의 정보를 사용할 있도록 세션에 보관한다.
    session.setAttribute("loginUser", loginUser);

    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/member/getLoginUser")
  public Object getLoginUser(HttpSession session) {
    Object sign = session.getAttribute("loginUser");
    if (sign != null) {
      return new ResultMap().setStatus(SUCCESS).setData(sign);
    } else {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }
  }
  //sign -> member로 바꿈

  @RequestMapping("/member/signout")
  public Object signout(HttpSession session) {
    session.invalidate();
    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/member/findid")
  public Object findid(String name, String tel) {
    Member findid = memberService.find(name, tel);
    if (findid == null) {
      return 0;
    }
    return memberService.find(name, tel).getEmail();
  }

  @RequestMapping("/member/findpwd")
  public Object findpwd(String email, String tel) {
    Member findpwd = memberService.send(email, tel);
    if (findpwd == null) {
      return 0;
    }
    MemberDto em = memberService.createMailandChangePassword(email);
    if (em == null) {
      return 0;
    }
    memberService.mailSend(em);
    return 1;

  }
}