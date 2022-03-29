package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Recruit;

//코드 수정시 저한테 말해주세요 - 경현

public interface RecruitService {

  int add(Recruit recruit);

  List<Recruit> list();

  Recruit get(int no);

  int update(Recruit recruit);

  int delete(int no);

}
