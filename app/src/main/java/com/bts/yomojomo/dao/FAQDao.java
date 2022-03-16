package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.FAQ;

@Mapper 
public interface FAQDao {
  int countAll();

  List<FAQ> findAll();

  int insert(FAQ faq);

  FAQ findByNo(int no);

  int update(FAQ faq);

  int delete(int no);
}
