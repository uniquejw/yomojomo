package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.ApplyFormDao;
import com.bts.yomojomo.domain.ApplayForm;

@RestController
public class ApplyFormController {
  @Autowired
  ApplyFormDao applayFormDao;

  @RequestMapping("/applayform/add")
  public Object add(ApplayForm applayForm) {
    return applayFormDao.insert(applayForm);
  }

  @RequestMapping("/applayform/get")
  public Object get(int no) {
    return applayFormDao.findByNo(no);
  }

  @RequestMapping("/applayform/list")
  public Object list() {
    return applayFormDao.findAll(); 
  }

  @RequestMapping("/applayform/update")
  public Object update(ApplayForm applayForm) {
    return applayFormDao.update(applayForm);
  }

  @RequestMapping("/applayform/delete")
  public Object delete(int no) {
    return applayFormDao.delete(no);
  }
}
