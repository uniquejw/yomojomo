package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.InviteBox;

@Mapper 
public interface InviteBoxDao {

  List<InviteBox> invitationList(InviteBox inviteBox);

  int createInvitation(InviteBox inviteBox);

}
