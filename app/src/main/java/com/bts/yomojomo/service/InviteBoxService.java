package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.InviteBox;

public interface InviteBoxService {

  List<InviteBox> inviteListByRecipient(InviteBox inviteBox);

  List<InviteBox> inviteListBySender(int pageSize, int pageNo, int memberNo);

  int mypageSize(int memberNo);

  int send(InviteBox inviteBox);

  InviteBox get(int inviteNo, int senderNo);

  int delete(InviteBox inviteBox);

  int update(InviteBox inviteBox);

}
