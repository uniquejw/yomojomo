package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.GroupApplyForm;

public interface GroupApplyService {

  List<GroupApplyForm> sendList(GroupApplyForm groupApplyForm);
}
