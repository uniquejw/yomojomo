//package com.bts.yomojomo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.bts.yomojomo.dao.GroupDao;
//import com.bts.yomojomo.domain.Group;
//
//@RestController
//public class GroupController {
//  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
// GroupDao groupDao;
//
//  @RequestMapping("/group/add")
//  public int add(Group group) {
//    return groupDao.insert(group);
//  }
//
//  @RequestMapping("/group/get")
//  public Object get(int no) {
//    return groupDao.findByNo(no);
//  }
//
//  @RequestMapping("/group/list")
//  public Object list() {
//    return groupDao.findAll(); 
//  }
//
//  @RequestMapping("/group/update")
//  public int update(Group group) {
//    return groupDao.update(group);
//  }
//
//  @RequestMapping("/group/delete")
//  public Object delete(int no) {
//    return groupDao.delete(no);
//  }
//}