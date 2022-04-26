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
  public List<InviteBox> inviteListByRecipient(InviteBox inviteBox) {
    return inviteBoxDao.findInviteListByRecipient(inviteBox);
  }

  @Override
  public List<InviteBox> inviteListBySender(int pageSize, int pageNo, int memberNo) {
    return inviteBoxDao.findinvitelistBySender(pageSize, ((pageNo - 1) * pageSize), memberNo);
  }

  @Override
  public int send(InviteBox inviteBox) {
    return inviteBoxDao.createInvitation(inviteBox);
  }

  @Override
  public int mypageSize(int memberNo) {
    return inviteBoxDao.countSender(memberNo);
  }

  @Override
  public int delete(InviteBox inviteBox) {
    return inviteBoxDao.delete(inviteBox);
  }

  @Override
  public InviteBox get(int inviteNo, int senderNo) {
    return inviteBoxDao.findByNo(inviteNo, senderNo);
  }

}
