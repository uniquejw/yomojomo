package com.bts.yomojomo.service;

import java.util.List;

import com.bts.yomojomo.domain.Notice;

public interface NoticeService {

  int add(Notice notice);

  List<Notice> list();

  Notice get(int no);

  int update(Notice notice);

  int delete(Notice notice);
}