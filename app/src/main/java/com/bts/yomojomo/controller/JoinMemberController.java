package com.bts.yomojomo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.JoinMemberDao;
import com.bts.yomojomo.domain.JoinMember;




@RestController
public class JoinMemberController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
  JoinMemberDao joinMemberDao;

  @RequestMapping("/joinmember/add")
  public int add(JoinMember joinMember) {
    return joinMemberDao.insert(joinMember);
  }

  @RequestMapping("/joinmember/get")
  public Object get(int no) {
    return joinMemberDao.findByNo(no);
  }

  @RequestMapping("/joinmember/list")
  public Object list() {
    return joinMemberDao.findAll(); 
  }

  @RequestMapping("/joinmember/update")
  public int update(JoinMember joinMember) {
    return joinMemberDao.update(joinMember);
  }

  @RequestMapping("/joinmember/delete")
  public Object delete(int no) {
    return joinMemberDao.delete(no);
  }
}