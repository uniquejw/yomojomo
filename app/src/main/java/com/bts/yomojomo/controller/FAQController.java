package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.FAQDao;
import com.bts.yomojomo.domain.FAQ;

@RestController
public class FAQController {
  @Autowired
  FAQDao faqDao;

  @RequestMapping("/faq/add")
  public Object add(FAQ faq) {
    return faqDao.insert(faq);
  }

  @RequestMapping("/faq/get")
  public Object get(int no) {
    return faqDao.findByNo(no);
  }

  @RequestMapping("/faq/list")
  public Object list() {
    return faqDao.findAll(); 
  }

  @RequestMapping("/faq/update")
  public Object update(FAQ faq) {
    return faqDao.update(faq);
  }

  @RequestMapping("/faq/delete")
  public Object delete(int no) {
    return faqDao.delete(no);
  }
}
