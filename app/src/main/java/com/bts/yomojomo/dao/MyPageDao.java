package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.MyPage;

@Mapper
public interface MyPageDao {

  List<MyPage> findAll();

  MyPage findByMemberNo(int no);

  int update(MyPage mypage);

  int deleteLocal(String email);

  int deletePurpose(String email);

  //  int insertLocal(MyPage mypage);
  //
  //  int insertPurpose(MyPage mypage);

}
