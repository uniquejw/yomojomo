package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.Purpose;

@Mapper
public interface PurposeDao {
  int countAll();

  List<Purpose> findAll();

  int insert(Purpose purpose);

  Purpose findByNo(int no);

  int update(Purpose purpose);

  int delete(int no);
}
