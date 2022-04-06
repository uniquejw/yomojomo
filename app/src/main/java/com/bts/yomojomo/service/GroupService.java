package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Group;

//코드 수정시 저한테 말해주세요 - 경현

public interface GroupService {

  int add(Group group);

  List<Group> list();

  Group get(int no);

  int update(Group group);

  int delete(int no);

}
