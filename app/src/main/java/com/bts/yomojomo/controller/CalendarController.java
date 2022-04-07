package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Calendar;
import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.service.CalendarSerivce;

@RestController
public class CalendarController {

  private static final Logger log = LoggerFactory.getLogger(PickmeController.class);

  @Autowired
  CalendarSerivce calendarservice;

  @RequestMapping("/calendar/list")
  public Object list() {
    log.info("캘린더 목록 조회");
    return new ResultMap().setStatus(SUCCESS).setData(calendarservice.list());
  }

  @RequestMapping("/calendar/add")
  public int add(Calendar calendar, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    //    calendar.set
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

  @RequestMapping("/calendar/update")
  public Object update(Calendar calendar) {
    return calendarservice.update(calendar);
  }

  @RequestMapping("/calendar/delete")
  public Object delete(int no) {
    return calendarservice.delete(no);
  }
}
