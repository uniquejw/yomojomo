package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.ActiveLocal;

@Mapper
public interface ActiveLocalDao {
  int countAll();

  List<ActiveLocal> findAll();

  int insert(ActiveLocal activeLocal);

  ActiveLocal findByNo(int no);

  int update(ActiveLocal activeLocal);

  int delete(int no);
}
