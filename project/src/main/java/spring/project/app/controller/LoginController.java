package spring.project.app.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.project.app.model.common.commonUtils;
import spring.project.app.service.TestTableService;

@RequestMapping
public class LoginController {

	@Resource
	TestTableService testtableservice;

	@RequestMapping("/validationID.do")
	@ResponseBody
	public String checkID(String userid) throws Exception {
		System.out.println("입력받은 값 : " + userid);

		int checkid = testtableservice.SelectCheckID(userid); // 추가 입력
		System.out.println("checkid " + checkid);
		if (checkid >= 1) {
			return "FALSE";
		} else {
			return "TRUE";
		}
	}

	@RequestMapping("validationPW.do")
	@ResponseBody
	public String checkPW(HttpServletRequest request) {
		// todo commonutils 가져오기
		commonUtils utils = new commonUtils();

		HashMap paramMap = new HashMap();

		paramMap = utils.apiInit(request); //commonutils 에 추가
		System.out.println(paramMap);

		if (paramMap.get("userpw").equals(paramMap.get("checkuserpw"))) {
			return "TRUE";
		} else {

			return "FALSE";
		}

	}

}
