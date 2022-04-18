package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Pickme;

//코드 수정시 저한테 말해주세요 - 경현

public interface PickmeService {

  int add(Pickme pickme);

  List<Pickme> list(int pageSize, int pageNo);

  List<Pickme> findSelectSiList(String nameSi, int pageNo, int pageSize);

  List<Pickme> findSelectGuList(Pickme pickme);

  Pickme get(int no);

  int update(Pickme pickme);

  int delete(Pickme pickme);

  int size();

  int siCateSize(String nameSi);

}
