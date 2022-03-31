package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Accounting;
import com.bts.yomojomo.service.AccountingService;

@RestController
public class AccountingController {
  @Autowired 
  AccountingService accountingService;

  @RequestMapping("/accounting/add")
  public int add(Accounting accounting) {
    return accountingService.add(accounting);
  }

  @RequestMapping("/accounting/get")
  public Object get(int no) {
    Accounting accounting = accountingService.get(no);
    if (accounting == null) {
      return "";
    }
    return accounting;
  }

  @RequestMapping("/accounting/list")
  public Object list() {
    return accountingService.list();
  }

  @RequestMapping("/accounting/update")
  public int update(Accounting accounting) {


    return accountingService.update(accounting);
  }

  @RequestMapping("/accounting/delete")
  public Object delete(int no) {
    return accountingService.delete(no);
  }
}