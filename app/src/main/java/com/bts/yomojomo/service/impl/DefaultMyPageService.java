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
  public List<MyPage> list() {
    return mypageDao.findAll();
  }

  @Override
  public MyPage get(int no) {
    MyPage mypage = mypageDao.findByMemberNo(no);
    return mypage;
  }

  @Override
  public int update(MyPage mypage) {
    mypageDao.update(mypage);
    return 1;
  }

  @Override
  public int deleteCategory(String email) {
    mypageDao.deleteLocal(email);
    mypageDao.deletePurpose(email);
    return 1;
  }

  //  @Override
  //  public int insertCategory(MyPage mypage) {
  //    mypageDao.insertLocal(mypage);
  //    mypageDao.insertPurpose(mypage);
  //    return 1;
  //}
}
