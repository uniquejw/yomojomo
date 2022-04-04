package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bts.yomojomo.dao.RecruitDao;
import com.bts.yomojomo.domain.Recruit;
import com.bts.yomojomo.service.RecruitService;

//코드 수정시 저한테 말해주세요 - 경현

@Service
public class DefaultRecruitService implements RecruitService{

  @Autowired
  RecruitDao recruitDao;

  @Transactional
  @Override
  public int add(Recruit recruit) {
    return recruitDao.insert(recruit);
  }

  @Override
  public List<Recruit> list() {
    return recruitDao.findAll();
  }

  @Override
  public Recruit get(int no) {
    Recruit recruit = recruitDao.findByNo(no);

    if (recruit != null) {
      recruitDao.increaseViewCount(no);
    }
    return recruit;
  }

  @Transactional
  @Override
  public int update(Recruit recruit) {
    return recruitDao.update(recruit);
  }

  @Transactional
  @Override
  public int delete(int no) {
    return recruitDao.delete(no);
  }

}
