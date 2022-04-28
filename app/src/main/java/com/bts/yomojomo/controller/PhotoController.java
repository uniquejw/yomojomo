package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.dao.PhotoDao;
import com.bts.yomojomo.domain.Photo;

@RestController
public class PhotoController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
  PhotoDao photoDao;

  @RequestMapping("/photo/add")
  public Object add(Photo photo) {
    return photoDao.insert(photo);
  }

  @RequestMapping("/photo/get")
  public Object get(int no) {
    return photoDao.findByNo(no);
  }

  @RequestMapping("/photo/list")
  public Object list() {
    return photoDao.findAll(); 
  }

  @RequestMapping("/photo/update")
  public Object update(Photo photo) {
    return photoDao.update(photo);
  }

  @RequestMapping("/photo/delete")
  public Object delete(int no) {
    return photoDao.delete(no);
  }
}
