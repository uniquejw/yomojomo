//package com.bts.yomojomo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.bts.yomojomo.dao.AccountingDao;
//import com.bts.yomojomo.domain.Accounting;
//
//@RestController
//public class AccountingController {
//  @Autowired 
//  AccountingDao accountingDao;
//
//  @RequestMapping("/accounting/add")
//  public int add(Accounting accounting) {
//    return accountingDao.insert(accounting);
//  }
//
//  @RequestMapping("/accounting/get")
//  public Object get(int no) {
//    return accountingDao.findByNo(no);
//  }
//
//  @RequestMapping("/accounting/list")
//  public Object list() {
//    return accountingDao.findAll(); 
//  }
//
//  @RequestMapping("/accounting/update")
//  public int update(Accounting accounting) {
//    return accountingDao.update(accounting);
//  }
//
//  @RequestMapping("/accounting/delete")
//  public Object delete(int no) {
//    return accountingDao.delete(no);
//  }
//}