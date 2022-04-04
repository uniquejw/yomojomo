package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Calendar;

public interface CalendarSerivce {

  int add(Calendar calendar);

  List<Calendar> list();

  Calendar get(int no);

  int update(Calendar calendar);

  int delete(int no);

}
