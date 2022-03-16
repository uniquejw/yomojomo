package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.CommentDao;
import com.bts.yomojomo.domain.Comment;

@RestController
public class CommentController {
  @Autowired
  CommentDao commentDao;

  @RequestMapping("/comment/add")
  public Object add(Comment comment) {
    return commentDao.insert(comment);
  }

  @RequestMapping("/comment/get")
  public Object get(int no) {
    return commentDao.findByNo(no);
  }

  @RequestMapping("/comment/list")
  public Object list() {
    return commentDao.findAll(); 
  }

  @RequestMapping("/comment/update")
  public Object update(Comment comment) {
    return commentDao.update(comment);
  }

  @RequestMapping("/comment/delete")
  public Object delete(int no) {
    return commentDao.delete(no);
  }
}
