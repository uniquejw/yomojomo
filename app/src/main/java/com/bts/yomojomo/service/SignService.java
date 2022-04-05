package com.bts.yomojomo.service;

import com.bts.yomojomo.domain.Sign;

public interface SignService {

	  int add(Sign sign);

	  Sign get(String email, String password);

}
