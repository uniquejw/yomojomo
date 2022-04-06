package com.bts.yomojomo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Recruit;
import com.bts.yomojomo.service.RecruitService;

@RestController
public class RecruitController {

  //log를 출력하는 도구 준비
  private static final Logger log = LoggerFactory.getLogger(RecruitController.class);

  @Autowired 
  RecruitService recruiteService;

  @RequestMapping("/recruit/list")
  public Object list() {
    //    log.error("error....");
    //    log.warn("warn....");
    //    log.info("info....");
    //    log.debug("debug....");
    //    log.trace("trace....");

    log.info("게시물 목록 조회");
    return recruiteService.list();
  }

  @RequestMapping("/recruit/add")
  public int add(Recruit recruit) {

    log.info("게시글 등록!"); //운영자가 확인하기를 원하는 정보
    log.debug(recruit.toString()); //개발자가 확인하기를 원하는 정보
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