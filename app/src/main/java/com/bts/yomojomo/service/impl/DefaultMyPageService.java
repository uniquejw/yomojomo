package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bts.yomojomo.dao.MyPageDao;
import com.bts.yomojomo.domain.MyPage;
import com.bts.yomojomo.service.MyPageService;

@Service
public class DefaultMyPageService implements MyPageService {

  @Autowired
  MyPageDao mypageDao;

  @Override
  public List<MyPage> list(String email) {
    return mypageDao.findAll(email);
  }
}
