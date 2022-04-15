package com.bts.yomojomo.service;

import com.bts.yomojomo.domain.Member;
import com.bts.yomojomo.dto.MemberDto;

public interface MemberService {

	int add(Member member);

	Member get(String email);

	Member get(String email, String password);

	Member find(String name, String tel);

	Member send(String email, String tel);

	Member send(String email);

	MemberDto createMailandChangePassword(String email);

	void updatePassword(String str, String userEmail);

	public String getTempPassword();

	public void mailSend(MemberDto memberDto);
}
