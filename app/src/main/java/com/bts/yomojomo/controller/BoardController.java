package com.bts.yomojomo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bts.yomojomo.domain.Board;
import com.bts.yomojomo.service.BoardService;


//->요청 파라미터 분석 및 가공
//-> 응답 데이터 가공 
@RestController
public class BoardController {

  @Autowired
  BoardService boardService ;

  @RequestMapping("/board/add")
  public Object add(Board board, MultipartFile file,HttpSession session ) {

    return boardService.add(board);
  }

  @RequestMapping("/board/get")
  public Object get(int no) {
    return boardService.get(no);
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardService.list(); 
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    return boardService.update(board);
  }

  @RequestMapping("/board/delete")
  public Object delete(Board board) {
    return boardService.delete(board);
  }
}
