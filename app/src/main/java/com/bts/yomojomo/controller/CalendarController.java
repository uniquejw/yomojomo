package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.CalendarDao;
import com.bts.yomojomo.domain.Calendar;

@RestController
public class CalendarController {
  @Autowired
  CalendarDao calendarDao;

  @RequestMapping("/calendar/add")
  public Object add(Calendar calendar) {
    return calendarDao.insert(calendar);
  }

  @RequestMapping("/calendar/get")
  public Object get(int no) {
    return calendarDao.findByNo(no);
  }

  @RequestMapping("/calendar/list")
  public Object list() {
    return calendarDao.findAll(); 
  }

  @RequestMapping("/calendar/update")
  public Object update(Calendar calendar) {
    return calendarDao.update(calendar);
  }

  @RequestMapping("/calendar/delete")
  public Object delete(int no) {
    return calendarDao.delete(no);
  }
}
