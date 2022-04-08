package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.ActiveLocal;

public interface ActiveLocalService {

  List<ActiveLocal> list();

  ActiveLocal get(int no);

  List<ActiveLocal> list(String si);

}
