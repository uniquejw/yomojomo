package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Calendar;

public interface CalendarSerivce {

  List<Calendar> list();

  int add(Calendar calendar);

  Calendar get(int no);

  int update(Calendar calendar);

  int delete(Calendar calendar);

}
