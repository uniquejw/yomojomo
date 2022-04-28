package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.NoticeDao;
import com.bts.yomojomo.domain.Notice;

@RestController
public class NoticeController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
  NoticeDao noticeDao;

  @RequestMapping("/notice/add")
  public Object add(Notice notice) {
    return noticeDao.insert(notice);
  }

  @RequestMapping("/notice/get")
  public Object get(int no) {
    return noticeDao.findByNo(no);
  }

  @RequestMapping("/notice/list")
  public Object list() {
    return noticeDao.findAll(); 
  }

  @RequestMapping("/notice/update")
  public Object update(Notice notice) {
    return noticeDao.update(notice);
  }

  @RequestMapping("/notice/delete")
  public Object delete(int no) {
    return noticeDao.delete(no);
  }
}