package com.bts.yomojomo.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.GroupApplyForm;

@Mapper
public interface GroupApplyFormDao {
  Object getmasterUser(GroupApplyForm groupApplyForm);
}
