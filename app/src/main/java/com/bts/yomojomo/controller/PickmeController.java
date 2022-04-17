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
  public Object list(int pageSize, int pageNo, HttpSession session) {

    log.info("게시물 목록 조회");

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (pageSize < 10 || pageSize > 100) {
        pageSize = 10;
      }
    } catch (Exception e) {}

    //    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int pickmeSize = pickmeService.size(); 

    int totalPageSize = pickmeSize / pageSize; // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 

    if ((pickmeSize % pageSize) > 0) {
      totalPageSize++;
    }

    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (pageNo < 1 || pageNo > totalPageSize) {// pageNo 유효성 검증
        pageNo = 1;
      }
    } catch (Exception e) {}

    return 
        new ResultMap().setStatus(SUCCESS).setPageNo(pageNo).setData(pickmeService.list(pageSize, pageNo));
  }

  @RequestMapping("/pickme/count")
  public Object countList(HttpSession session) {
    log.info("게시물 총 개수 조회");
    return new ResultMap().setStatus(SUCCESS).setData(pickmeService.size());
  }

  @RequestMapping("/pickme/selectedSicate") 
  public Object selectedSicate(int pageNo, int pageSize, String nameSi, HttpSession session) {
    log.info("시별 카테고리 리스트 조회");

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (pageSize < 10 || pageSize > 100) {
        pageSize = 10;
      }
    } catch (Exception e) {}

    int siCateSize = pickmeService.siCateSize(nameSi);
    System.out.println("시 카테고리 전체 글 개수 " + siCateSize);

    int totalSiCatePageSize = siCateSize / pageSize;
    System.out.println("시 카테고리 전체 페이지 개수 " + totalSiCatePageSize);

    if((siCateSize % pageSize) > 0) {
      totalSiCatePageSize++;
    }

    try {
      if (pageNo < 1  || pageNo > totalSiCatePageSize) {
        pageNo = 1;
      }
    } catch (Exception e) {}

    return new ResultMap().setStatus(SUCCESS).setPageNo(pageNo).setData(pickmeService.findSelectSiList(nameSi, pageNo, pageSize));
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