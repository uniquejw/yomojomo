package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.Accounting;
import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.service.AccountingService;

@RestController
public class AccountingController {

  private static final Logger log = LoggerFactory.getLogger(CalendarController.class);

  @Autowired 
  AccountingService accountingService;

  @RequestMapping("/accounting/list") //나중에 member 완료되면 group no로 바꾸기 까먹지말기
  public Object list(HttpSession session) {
    log.info("캘린더 목록 조회");
    return new ResultMap().setStatus(SUCCESS).setData(accountingService.list());
  }

  @RequestMapping("/accounting/catelist") 
  public Object catelist(HttpSession session) {
    log.info("카테고리 리스트 조회");
    return new ResultMap().setStatus(SUCCESS).setData(accountingService.findCateList());
  }

  @RequestMapping("/accounting/selectedcate")
  public Object selectedCate(Accounting accounting, HttpSession session) {
    log.info("카테고리 선택 리스트 조회");

    return new ResultMap().setStatus(SUCCESS).setData(accountingService.findSelectCateList(accounting));
  }

  @RequestMapping("/accounting/add")
  public Object add(Accounting accounting, HttpSession session) {
    log.info("정산등록");
    log.debug(accounting.toString());

    Member member = (Member) session.getAttribute("loginUser");
    accounting.setMember(member);
    accountingService.add(accounting);

    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/accounting/get")
  public Object get(int no, HttpSession session) {
    Accounting accounting = accountingService.get(no);
    if (accounting == null) {
      return new ResultMap().setStatus(FAIL).setData("해당 번호의 게시글이 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(accounting);
  }

  @RequestMapping("/accounting/update")
  public Object update(Accounting accounting, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    accounting.setMember(member);

    int count = accountingService.update(accounting);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/accounting/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    Accounting accounting = new Accounting();
    accounting.setNo(no);
    accounting.setMember(member);

    int count = accountingService.delete(accounting);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }
}