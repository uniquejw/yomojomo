package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.GroupTagDao;
import com.bts.yomojomo.domain.GroupTag;

@RestController
public class GroupTagController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
 GroupTagDao grouptagDao;

  @RequestMapping("/grouptag/add")
  public int add(GroupTag grouptag) {
    return grouptagDao.insert(grouptag);
  }

  @RequestMapping("/grouptag/get")
  public Object get(int no) {
    return grouptagDao.findByNo(no);
  }

  @RequestMapping("/grouptag/list")
  public Object list() {
    return grouptagDao.findAll(); 
  }

  @RequestMapping("/grouptag/update")
  public int update(GroupTag grouptag) {
    return grouptagDao.update(grouptag);
  }

  @RequestMapping("/grouptag/delete")
  public Object delete(int no) {
    return grouptagDao.delete(no);
  }
}