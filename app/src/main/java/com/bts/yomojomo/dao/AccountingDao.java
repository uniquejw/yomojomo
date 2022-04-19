package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.bts.yomojomo.domain.Accounting;
import com.bts.yomojomo.domain.AccountingCate;

@Mapper 
public interface AccountingDao {
  int countAll(@Param("groupNo") int groupNo, @Param("actCate") String actCate);

  List<Accounting> findListByGroup(@Param("rowCount") int rowCount, @Param("offset") int offset, @Param("groupNo") int groupNo, @Param("actCate") String actCate);

  List<AccountingCate> cateListAll();

  int insert(Accounting accounting);

  Accounting findByNo(int no);

  int update(Accounting accounting);

  int delete(Accounting accounting);
}
