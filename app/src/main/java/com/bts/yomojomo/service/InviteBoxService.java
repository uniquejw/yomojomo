package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.InviteBox;

public interface InviteBoxService {

  List<InviteBox> findInvitationList(InviteBox inviteBox);

  int send(InviteBox inviteBox);

}
