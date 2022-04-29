package com.bts.yomojomo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bts.yomojomo.dao.GroupApplyFormDao;
import com.bts.yomojomo.domain.GroupApplyForm;
import com.bts.yomojomo.service.GroupApplyService;

@Service
public class DefaultGroupApplyService implements GroupApplyService{

  @Autowired
  GroupApplyFormDao groupApplyFormDao;

  @Override
  public Object masterUser(GroupApplyForm groupApplyForm) {
    return groupApplyFormDao.getmasterUser(groupApplyForm);
  }

}
