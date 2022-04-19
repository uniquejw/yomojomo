package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Accounting;
import com.bts.yomojomo.domain.AccountingCate;

public interface AccountingService {

  int add(Accounting accounting);

  List<Accounting> listByGroup(int pageSize, int pageNo, int groupNo, String actCate);

  List<AccountingCate> findCateList();

  Accounting get(int no);

  int update(Accounting accounting);

  int delete(Accounting accounting);

  int size(int groupNo, String actCate);

}
