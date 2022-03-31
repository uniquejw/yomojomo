package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Accounting;

public interface AccountingService {

  int add(Accounting accounting);

  List<Accounting> list();

  Accounting get(int no);

  int update(Accounting accounting);

  int delete(int no);

}
