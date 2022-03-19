package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.ActiveLocalDao;
import com.bts.yomojomo.domain.ActiveLocal;

@RestController
public class ActiveLocalController {
  @Autowired
  ActiveLocalDao activeLocalDao;

  @RequestMapping("/activelocal/add")
  public Object add(ActiveLocal activeLocal) {
    return activeLocalDao.insert(activeLocal);
  }

  @RequestMapping("/activelocal/get")
  public Object get(int no) {
    return activeLocalDao.findByNo(no);
  }

  @RequestMapping("/activelocal/list")
  public Object list() {
    return activeLocalDao.findAll(); 
  }

  @RequestMapping("/activelocal/update")
  public Object update(ActiveLocal activeLocal) {
    return activeLocalDao.update(activeLocal);
  }

  @RequestMapping("/activelocal/delete")
  public Object delete(int no) {
    return activeLocalDao.delete(no);
  }
}
