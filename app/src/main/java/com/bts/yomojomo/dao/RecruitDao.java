package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.ActiveLocal;
import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.domain.Purpose;
import com.bts.yomojomo.domain.Recruit;

@Mapper 
public interface RecruitDao {
  int countAll();

  List<Recruit> findAll();

  Recruit findByNo(int no);

  int insert(Recruit recruit);

  int update(Recruit recruit);

  int delete(int no);

  int increaseViewCount(int no);

  //관심지역 테이블
  List<ActiveLocal> findByActiveLocalNo(int activeLocalNo);

  //활동목적 테이블
  List<Purpose> findByPurposeNo(int purposeNo);

  //멤버 테이블
  List<Member> findByMemberNo(int memberNo);

}
