package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bts.yomojomo.domain.InviteBox;
import com.bts.yomojomo.domain.JoinMember;
import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.service.InviteBoxService;

@RestController
public class InviteBoxController {
  private static final Logger log = LoggerFactory.getLogger(InviteBoxController.class);

  @Autowired
  InviteBoxService inviteBoxService;

  @RequestMapping("/invitebox/mnolist")
  public Object invitationList(InviteBox inviteBox, HttpSession session) {
    //test : http://localhost:8080/invitebox/mnolist?member.no=초대받는사람번호
    log.info("초대받은 회원별 받은 초대 리스트 조회");

    return new ResultMap().setStatus(SUCCESS).setData(inviteBoxService.findInvitationList(inviteBox));
  }

  @RequestMapping("/invitebox/send")
  public Object sendInvitation(InviteBox inviteBox, HttpSession session) {
    log.info("초대장 발송");
    log.debug(inviteBox.toString());

    Member member = (Member) session.getAttribute("loginUser");
    JoinMember joinMember = new JoinMember();

    joinMember.setMember(member);
    inviteBoxService.send(inviteBox);

    return new ResultMap().setStatus(SUCCESS);
  }

}
