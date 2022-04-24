package com.bts.yomojomo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bts.yomojomo.domain.MemberMidpointSelect;

@Service
public interface MemberMidpointSelectService {
  List<MemberMidpointSelect> memberListByGroupAndCalendar(MemberMidpointSelect memberSelectMidpoint);
}
