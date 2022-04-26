package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.MyPage;

@Mapper
public interface MyPageDao {
  List<MyPage> findAll(String email);
}
