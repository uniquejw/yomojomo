package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Board;
import com.bts.yomojomo.domain.FAQ;
import com.bts.yomojomo.domain.Notice;

public interface FAQService {

  int add(FAQ faq);

  List<FAQ> list();

  Notice get(int no);

  int update(FAQ faq);

  int delete(FAQ faq);
}
