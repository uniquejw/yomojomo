package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.domain.Pickme;
import com.bts.yomojomo.service.PickmeService;

@RestController
public class PickmeController {

  //log를 출력하는 도구 준비
  private static final Logger log = LoggerFactory.getLogger(PickmeController.class);


  @Autowired 
  PickmeService pickmeService;

  @RequestMapping("/pickme/list")
  public Object list() {
    log.info("게시물 목록 조회");
    return pickmeService.list();
  }

  @RequestMapping("/pickme/selectedSicate") 
  public Object selectedSicate(Pickme pickme, HttpSession session) {
    log.info("시별 카테고리 리스트 조회");
    return new ResultMap().setStatus(SUCCESS).setData(pickmeService.findSelectSiList(pickme));
  }

  @RequestMapping("/pickme/selectedGucate") 
  public Object selectedGucate(Pickme pickme, HttpSession session) {
    log.info("구별 카테고리 리스트 조회");
    return new ResultMap().setStatus(SUCCESS).setData(pickmeService.findSelectGuList(pickme));
  }

  @RequestMapping("/pickme/add")
  public Object add(Pickme pickme, HttpSession session) {
    log.info("게시글 등록!"); // 운영자가 확인하기를 원하는 정보
    log.debug(pickme.toString()); // 개발자가 확인하기를 원하는 정보

    Member member = (Member) session.getAttribute("loginUser");
    pickme.setMember(member);
    pickmeService.add(pickme);

    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/pickme/get")
  public Object get(int no, HttpSession session) {
    Pickme pickme = pickmeService.get(no);
    if (pickme == null) {
      return new ResultMap().setStatus(FAIL).setData("해당 번호의 게시글이 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(pickme);
  }

  @RequestMapping("/pickme/update")
  public Object update(Pickme pickme, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    pickme.setMember(member);

    int count = pickmeService.update(pickme);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/pickme/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    Pickme pickme = new Pickme();
    pickme.setNo(no);
    pickme.setMember(member);

    int count = pickmeService.delete(pickme);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }
}