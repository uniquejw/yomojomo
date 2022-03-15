package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Destination;

@RestController
public class MemberController {
  @Autowired
  Member member;

  @RequestMapping("/member/add")
  public Object add(Member member) {
    return destinationDao.insert(member);
  }

  @RequestMapping("/member/get")
  public Object get(int no) {
    return destinationDao.findByNo(no);
  }

  @RequestMapping("/member/list")
  public Object list() {
    return destinationDao.findAll(); 
  }

  @RequestMapping("/member/update")
  public Object update(Destination destination) {
    return destinationDao.update(destination);
  }

  @RequestMapping("/member/delete")
  public Object delete(int no) {
    return destinationDao.delete(no);
  }

}
