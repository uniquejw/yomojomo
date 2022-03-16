//package com.bts.yomojomo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.bts.yomojomo.dao.NoticeQuestionDao;
//import com.bts.yomojomo.domain.NoticeQuestion;
//
//@RestController
//public class NoticeQuestionController {
//  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
//  NoticeQuestionDao noticeQuestionDao;
//
//  @RequestMapping("/noticeQuestion/add")
//  public Object add(NoticeQuestion noticequestion) {
//    return noticeQuestionDao.insert(noticequestion);
//  }
//
//  @RequestMapping("/noticeQuestion/get")
//  public Object get(int no) {
//    return noticeQuestionDao.findByNo(no);
//  }
//
//  @RequestMapping("/noticeQuestion/list")
//  public Object list() {
//    return noticeQuestionDao.findAll(); 
//  }
//
//  @RequestMapping("/noticeQuestion/update")
//  public Object update(NoticeQuestion noticequestion) {
//    return noticeQuestionDao.update(noticequestion);
//  }
//
//  @RequestMapping("/noticeQuestion/delete")
//  public Object delete(int no) {
//    return noticeQuestionDao.delete(no);
//  }
//}
