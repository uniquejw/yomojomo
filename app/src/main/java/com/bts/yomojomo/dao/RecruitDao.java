package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.Recruit;

@Mapper 
public interface RecruitDao {
  int countAll();

  List<Recruit> findAll();

  Recruit findByNo(int no);

  Recruit findByName(int name);

  int insert(Recruit recruit);

  int update(Recruit recruit);

  int delete(int no);

  int increaseViewCount(int no);


}
