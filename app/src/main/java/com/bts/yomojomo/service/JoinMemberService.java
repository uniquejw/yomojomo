package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.JoinMember;

public interface JoinMemberService {

  List<JoinMember> list();

  List<JoinMember> listbyGradeNo(JoinMember joinMember); //경현 - 수정시 말해주세요

  List<JoinMember> grouplistByMno(JoinMember joinMember); //경현 - 수정시 말해주세요

  int add(JoinMember joinMember);

  JoinMember get(int no);

  int update(JoinMember joinMember);

  int delete(int no);

}
