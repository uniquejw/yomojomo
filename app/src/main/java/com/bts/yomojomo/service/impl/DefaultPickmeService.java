package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bts.yomojomo.dao.PickmeDao;
import com.bts.yomojomo.domain.Pickme;
import com.bts.yomojomo.service.PickmeService;

//코드 수정시 저한테 말해주세요 - 경현

@Service
public class DefaultPickmeService implements PickmeService{

  @Autowired
  PickmeDao pickmeDao;

  @Transactional
  @Override
  public int add(Pickme pickme) {
    return pickmeDao.insert(pickme);
  }

  @Override
  public List<Pickme> list() {
    return pickmeDao.findAll();
  }

  @Override
  public List<Pickme> findSelectSiList(Pickme pickme) {
    return pickmeDao.selectedSicate(pickme);
  }

  @Override
  public List<Pickme> findSelectGuList(Pickme pickme) {
    return pickmeDao.selectedGucate(pickme);
  }

  @Override
  public Pickme get(int no) {
    Pickme pickme = pickmeDao.findByNo(no);

    if (pickme != null) {
      pickmeDao.increaseViewCount(no);
    }
    return pickme;
  }

  @Transactional
  @Override
  public int update(Pickme pickme) {
    return pickmeDao.update(pickme);
  }

  @Transactional
  @Override
  public int delete(Pickme pickme) {
    return pickmeDao.delete(pickme);
  }



}
