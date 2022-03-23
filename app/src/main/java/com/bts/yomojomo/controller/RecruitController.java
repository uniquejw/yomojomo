package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Recruit;
import com.bts.yomojomo.service.RecruitService;

@RestController
public class RecruitController {
  @Autowired 
  RecruitService recruiteService;

  @RequestMapping("/recruit/list")
  public Object list() {
    return recruiteService.list();
  }

  @RequestMapping("/recruit/add")
  public int add(Recruit recruit) {
    return recruiteService.add(recruit);
  }

  @RequestMapping("/recruit/get")
  public Object get(int no) {
    Recruit recruit = recruiteService.get(no);
    if (recruit == null) {
      return "";
    }
    return recruit;
  }

  @RequestMapping("/recruit/update")
  public int update(Recruit recruit) {
    return recruiteService.update(recruit);
  }

  @RequestMapping("/recruit/delete")
  public Object delete(int no) {
    return recruiteService.delete(no);
  }
}