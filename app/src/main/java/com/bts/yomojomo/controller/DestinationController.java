package com.bts.yomojomo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.yomojomo.dao.DestinationDao;
import com.bts.yomojomo.domain.Destination;

@RestController
public class DestinationController {
  @Autowired
  DestinationDao destinationDao;

  @RequestMapping("/destination/add")
  public Object add(Destination destination) {
    return destinationDao.insert(destination);
  }

  @RequestMapping("/destination/get")
  public Object get(int no) {
    return destinationDao.findByNo(no);
  }

  @RequestMapping("/destination/list")
  public Object list() {
    return destinationDao.findAll(); 
  }

  @RequestMapping("/destination/update")
  public Object update(Destination destination) {
    return destinationDao.update(destination);
  }

  @RequestMapping("/destination/delete")
  public Object delete(int no) {
    return destinationDao.delete(no);
  }

}
