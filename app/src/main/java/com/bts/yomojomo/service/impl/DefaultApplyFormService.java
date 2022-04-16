package com.bts.yomojomo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bts.yomojomo.dao.ApplyFormDao;
import com.bts.yomojomo.domain.ApplyAnswer;
import com.bts.yomojomo.domain.ApplyForm;
import com.bts.yomojomo.service.ApplyFormService;

//서비스객체 -> 업무로직, 트랜잭션 제어 
// => 일관성을 위해 반드시 서비스 객체를 통해 DAO를 사용한다. 
@Service // Spring IoC 컨테이너가 객체를 만들어 저장할 때 클래스 이름을 사용한다. 예) defaultBoardService
public class DefaultApplyFormService implements ApplyFormService {

  @Autowired
  ApplyFormDao applyFormDao;


  @Override
  public List<ApplyForm> findQuestion(int no) {
    return applyFormDao.findQuestion(no);
  }
  @Override
  public int add(ApplyForm applyForm,ApplyAnswer applyAnswer) {
    return applyFormDao.insert(applyForm, applyAnswer);
  }
  //
  //    @Override
  //    public List<ApplyForm> list() {
  //      return applyFormDao.findAll();
  //    }
  //
  //  @Override
  //  public ApplyForm get(int no) {
  //    return applyFormDao.findByNo(no);
  //  }
  //
  //  @Override
  //  public int update(ApplyForm applyForm) {
  //    return applyFormDao.update(applyForm);
  //  }
  //
  //  @Override
  //  public int delete(int no) {
  //    return applyFormDao.delete(no);
  //  }

}
