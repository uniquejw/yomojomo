//package com.bts.yomojomo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.bts.yomojomo.dao.DestinationDao;
//import com.bts.yomojomo.domain.Destination;
//
//@RestController
//public class DestinationController {
//  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
//  DestinationDao destinationDao;
//
//  @RequestMapping("/destination/add")
//  public int add(Destination destination) {
//    return destinationDao.insert(destination);
//  }
//
//  @RequestMapping("/destination/get")
//  public Object get(int no) {
//    return destinationDao.findByNo(no);
//  }
//
//  @RequestMapping("/destination/list")
//  public Object list() {
//    return destinationDao.findAll(); 
//  }
//
//  @RequestMapping("/destination/update")
//  public int update(Destination destination) {
//    return destinationDao.update(destination);
//  }
//
//  @RequestMapping("/destination/delete")
//  public Object delete(int no) {
//    return destinationDao.delete(no);
//  }
//}