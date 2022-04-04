package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Calendar;
import com.bts.yomojomo.service.CalendarSerivce;

@RestController
public class CalendarController {
  @Autowired
  CalendarSerivce calendarservice;

  @RequestMapping("/calendar/add")
  public int add(Calendar calendar) {
    return calendarservice.add(calendar);
  }

  @RequestMapping("/calendar/get")
  public Object get(int no) {
    Calendar calendar = calendarservice.get(no);
    if (calendar == null) {
      return "";
    }
    return calendar;
  }

  @RequestMapping("/calendar/list")
  public Object list() {
    return calendarservice.list();
  }

  @RequestMapping("/calendar/update")
  public Object update(Calendar calendar) {
    return calendarservice.update(calendar);
  }

  @RequestMapping("/calendar/delete")
  public Object delete(int no) {
    return calendarservice.delete(no);
  }
}
