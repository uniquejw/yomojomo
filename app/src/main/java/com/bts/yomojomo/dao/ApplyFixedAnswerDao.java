package com.bts.yomojomo.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.ApplyFixedAnswer;

@Mapper 
public interface ApplyFixedAnswerDao {
  //  int countAll();
  //
  //  List<ApplyAnswer> findAll();


  int insert(ApplyFixedAnswer applyFixedAnswer);

  //  ApplyAnswer findByNo(int no);
  //
  //  int update(ApplyAnswer applyAnswer);
  //
  //  int delete(int no);

}
