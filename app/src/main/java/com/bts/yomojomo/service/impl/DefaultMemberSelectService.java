package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bts.yomojomo.dao.MemberMidpointSelectDao;
import com.bts.yomojomo.domain.MemberMidpointSelect;
import com.bts.yomojomo.service.MemberMidpointSelectService;

public class DefaultMemberSelectService implements MemberMidpointSelectService {

  @Autowired
  MemberMidpointSelectDao memberMidpointSelectDao;

  @Override
  public List<MemberMidpointSelect> memberListByGroupAndCalendar(
      MemberMidpointSelect memberSelectMidpoint) {
    return memberMidpointSelectDao.findAll(memberSelectMidpoint);
  }

}
