package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.PurposeDao;
import com.bts.yomojomo.domain.Purpose;

@RestController
public class PurposeController {
  @Autowired
  PurposeDao purposeDao;

  @RequestMapping("/purpose/add")
  public Object add(Purpose purpose) {
    return purposeDao.insert(purpose);
  }

  @RequestMapping("/purpose/get")
  public Object get(int no) {
    return purposeDao.findByNo(no);
  }

  @RequestMapping("/purpose/list")
  public Object list() {
    return purposeDao.findAll(); 
  }

  @RequestMapping("/purpose/update")
  public Object update(Purpose purpose) {
    return purposeDao.update(purpose);
  }

  @RequestMapping("/purpose/delete")
  public Object delete(int no) {
    return purposeDao.delete(no);
  }
}
