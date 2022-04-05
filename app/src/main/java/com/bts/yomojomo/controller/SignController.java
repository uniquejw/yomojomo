package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.yomojomo.domain.Sign;
import com.bts.yomojomo.service.SignService;


@RestController
public class SignController {

	@Autowired
	SignService signService;

	@RequestMapping("/sign/signup")
	public Object signUp(Sign sign) {
		if (signService.add(sign) == 1) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/sign/signin")
	public Object signin(String email, String password, HttpSession session) {
		Sign loginUser = signService.get(email, password);
		if (loginUser == null) {
			
			return "fail";
		}

		// 로그인이 성공하면,
		// 다른 요청을 처리할 때 로그인 회원의 정보를 사용할 있도록 세션에 보관한다.
		session.setAttribute("loginUser", loginUser);

		return "success";
	}

	@RequestMapping("/sign/getLoginUser")
	public Object getLoginUser(HttpSession session) {
		Object sign = session.getAttribute("loginUser");
		if (sign != null) {
			return new ResultMap().setStatus(SUCCESS).setData(sign);
		} else {
			return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
		}
	}

	@RequestMapping("/sign/signout")
	public Object signout(HttpSession session) {
		session.invalidate();
		return new ResultMap().setStatus("success");
	}
}