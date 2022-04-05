package com.bts.yomojomo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.yomojomo.dao.SignDao;
import com.bts.yomojomo.domain.Sign;
import com.bts.yomojomo.service.SignService;

@Service
public class DefaultSignService implements SignService {

  @Autowired
  SignDao signDao;

  @Override
  public int add(Sign sign) {
    return signDao.insert(sign);
  }

  @Override
  public Sign get(String email, String password) {
    return signDao.findByEmailAndPassword(email, password);
  }


}
