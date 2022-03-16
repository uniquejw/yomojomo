//package com.bts.yomojomo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.bts.yomojomo.dao.AccountingCateDao;
//import com.bts.yomojomo.domain.AccountingCate;
//
//@RestController
//public class AccountingCateController {
//  @Autowired
//  AccountingCateDao accountingcateDao;
//
//  @RequestMapping("/accountingcate/add")
//  public Object add(AccountingCate accountingCate) {
//    return accountingcateDao.insert(accountingCate);
//  }
//
//  @RequestMapping("/accountingcate/get")
//  public Object get(int no) {
//    return accountingcateDao.findByNo(no);
//  }
//
//  @RequestMapping("/accountingcate/list")
//  public Object list() {
//    return accountingcateDao.findAll(); 
//  }
//
//  @RequestMapping("/accountingcate/update")
//  public Object update(AccountingCate accountingCate) {
//    return accountingcateDao.update(accountingCate);
//  }
//
//  @RequestMapping("/accountingcate/delete")
//  public Object delete(int no) {
//    return accountingcateDao.delete(no);
//  }
//}
