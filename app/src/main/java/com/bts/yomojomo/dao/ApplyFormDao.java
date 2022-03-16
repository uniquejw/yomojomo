package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.ApplayForm;

@Mapper 
public interface ApplyFormDao {
  int countAll();

  List<ApplayForm> findAll();

  int insert(ApplayForm applayForm);

  ApplayForm findByNo(int no);

  int update(ApplayForm applayForm);

  int delete(int no);
}
