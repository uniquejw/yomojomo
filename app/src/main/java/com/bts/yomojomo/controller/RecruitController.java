package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.RecruitDao;
import com.bts.yomojomo.domain.Recruit;

@RestController
public class RecruitController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
  RecruitDao recruitDao;

  @RequestMapping("/recruit/add")
  public int add(Recruit recruit) {
    return recruitDao.insert(recruit);
  }

  @RequestMapping("/recruit/get")
  public Object get(int no) {
    recruitDao.increaseViewCount(no);
    return recruitDao.findByNo(no);
  }

  @RequestMapping("/recruit/list")
  public Object list() {
    return recruitDao.findAll(); 
  }

  @RequestMapping("/recruit/update")
  public int update(Recruit recruit) {
    return recruitDao.update(recruit);
  }

  @RequestMapping("/recruit/delete")
  public Object delete(int no) {
    return recruitDao.delete(no);
  }
}