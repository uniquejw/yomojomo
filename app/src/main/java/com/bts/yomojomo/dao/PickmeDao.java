package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.bts.yomojomo.domain.Pickme;

@Mapper 
public interface PickmeDao {
  int countAll();

  List<Pickme> findAll(@Param("rowCount") int rowCount, @Param("offset") int offset);

  List<Pickme> selectedSicate(Pickme pickme);

  List<Pickme> selectedGucate(Pickme pickme);

  Pickme findByNo(int no);

  Pickme findByName(int memberName);

  int insert(Pickme pickme);

  int update(Pickme pickme);

  int delete(Pickme pickme);

  int increaseViewCount(int no);


}
