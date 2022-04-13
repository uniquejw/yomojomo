package com.bts.yomojomo.domain;

import java.sql.Date;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Member {
  int no; //memb_no
  String memberName;
  String passWord;
  String email;
  String tel;
  String postNo;
  String baseAddress;
  String address;
  String type;
  int unsubscribe;
  int status;
  Date stopDate;
 
  List<FinalActiveLocal> locals;
  List<FinalPurpose> pups;
}
