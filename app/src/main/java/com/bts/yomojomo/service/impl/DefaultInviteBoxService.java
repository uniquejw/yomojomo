package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bts.yomojomo.dao.InviteBoxDao;
import com.bts.yomojomo.domain.InviteBox;
import com.bts.yomojomo.service.InviteBoxService;

@Service
public class DefaultInviteBoxService implements InviteBoxService{

  @Autowired
  InviteBoxDao inviteBoxDao;

  @Override
  public List<InviteBox> findInvitationList(InviteBox inviteBox) {
    return inviteBoxDao.invitationList(inviteBox);
  }

  @Override
  public int send(InviteBox inviteBox) {
    return inviteBoxDao.createInvitation(inviteBox);
  }


}
