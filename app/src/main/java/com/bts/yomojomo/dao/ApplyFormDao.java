package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.ApplyForm;

@Mapper 
public interface ApplyFormDao {

  List<ApplyForm> findQuestion(int no);
  //  int countAll();
  //
  //  List<ApplyForm> findAll();
  //
  //  int insert(ApplyForm applayForm);
  //
  //  ApplyForm findByNo(int no);
  //
  //  int update(ApplyForm applayForm);
  //
  //  int delete(int no);
}
