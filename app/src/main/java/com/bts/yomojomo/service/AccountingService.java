package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Accounting;
import com.bts.yomojomo.domain.AccountingCate;

public interface AccountingService {

  int add(Accounting accounting);

  List<Accounting> list();

  List<Accounting> listByGroup(Accounting accounting);

  List<AccountingCate> findCateList();

  List<Accounting> findSelectCateList(Accounting accounting);

  Accounting get(int no);

  int update(Accounting accounting);

  int delete(Accounting accounting);

}
