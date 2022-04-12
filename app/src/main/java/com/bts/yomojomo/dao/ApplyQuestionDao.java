package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.ApplyQuestion;

@Mapper 
public interface ApplyQuestionDao {
  int countAll();

  List<ApplyQuestion> findAll();

  int insert(ApplyQuestion applyQuestion);

  ApplyQuestion findByNo(int no);

  int update(ApplyQuestion applyQuestion);

  int delete(int no);
}
