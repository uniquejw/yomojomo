package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.MyPage;

public interface MyPageService {

  List<MyPage> list(String email);
}
