package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.MemberDao;
import com.bts.yomojomo.domain.Member;

@RestController
public class MemberController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
  MemberDao memberDao;

  @RequestMapping("/member/add")
  public int add(Member member) {
    return memberDao.insert(member);
  }

  @RequestMapping("/member/get")
  public Object get(int no) {
    return memberDao.findByNo(no);
  }

  @RequestMapping("/member/list")
  public Object list() {
    return memberDao.findAll(); 
  }

  @RequestMapping("/member/update")
  public int update(Member member) {
    return memberDao.update(member);
  }

  @RequestMapping("/member/delete")
  public Object delete(int no) {
    return memberDao.delete(no);
  }
}