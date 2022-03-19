package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.BoardDao;
import com.bts.yomojomo.domain.Board;

@RestController
public class BoardController {
  @Autowired
  BoardDao boardDao;

  @RequestMapping("/board/add")
  public Object add(Board board) {
    return boardDao.insert(board);
  }

  @RequestMapping("/board/get")
  public Object get(int no) {
    return boardDao.findByNo(no);
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    return boardDao.update(board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int no) {
    return boardDao.delete(no);
  }
}
