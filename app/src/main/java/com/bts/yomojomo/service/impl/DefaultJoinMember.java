package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bts.yomojomo.dao.JoinMemberDao;
import com.bts.yomojomo.domain.JoinMember;
import com.bts.yomojomo.service.JoinMemberService;

@Service
public class DefaultJoinMember implements JoinMemberService{

  @Autowired
  JoinMemberDao joinMemberDao;

  @Transactional
  @Override
  public List<JoinMember> list() {
    return joinMemberDao.findAll();
  }

  @Override // 경현 - 수정시 말해주세용
  public List<JoinMember> findByGradeNo(int no) {
    return joinMemberDao.findByGradeNo(no);
  }

  @Override
  public int add(JoinMember joinMember) {
    return joinMemberDao.insert(joinMember);
  }

  @Override
  public JoinMember get(int no) {
    JoinMember joinMember = joinMemberDao.findByNo(no);
    return joinMember;
  }

  @Transactional
  @Override
  public int update(JoinMember joinMember) {
    return joinMemberDao.update(joinMember);
  }

  @Transactional
  @Override
  public int delete(int no) {
    return joinMemberDao.delete(no);
  }


}
