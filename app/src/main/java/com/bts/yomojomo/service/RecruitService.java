package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Recruit;

public interface RecruitService {

  int add(Recruit recruit);

  List<Recruit> list();

  Recruit get(int no);

  int update(Recruit recruit);

  int delete(int no);

}
