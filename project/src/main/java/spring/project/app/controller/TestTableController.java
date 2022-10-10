package spring.project.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.project.app.model.common.commonUtils;
import spring.project.app.service.TestTableService;

@Controller
@RequestMapping("/")
public class TestTableController {

	@Resource
	private TestTableService testtableservice;

	@RequestMapping // 기본 디폴트 페이지
	public String mainPage() {
		System.out.println("mainPage");
		return "signin";
	}

	@RequestMapping(value = "/list.do") // 리스트 출력
	public String view(Model model) throws Exception {
		List<Map<String, Object>> AllList = testtableservice.SelectAllList();
		System.out.println(AllList);
		model.addAttribute("list", AllList); //유저 리스트
		return "list";
	}

	@RequestMapping(value = "/validation.do") // 아이디 사용가능한지 여부 확인 예정
	@ResponseBody // json 형태로 반환
	public String validateID(String userid) throws Exception {

		int checkID = testtableservice.SelectCheckID(userid); // 회원아이디 갯수가 1개이상이면 기가입 회원

		if (checkID != 0) { // 카운트 갯수
			return "이미 사용중인 아이디입니다.";
		} else {
			return userid + "는 사용가능한 아이디입니다";
		}
	}

	@RequestMapping(value = "/signin.do")
	public String SignInID() {

		return "signinpage";
	}

	@RequestMapping(value = "/apitest.do") // api컨트롤러 추가
	public String page(HttpServletRequest request) {
		commonUtils util = new commonUtils();
		util.apiInit(request);

		return "apitest";
	}

	@RequestMapping(value="/json.do")
	public String jsonpage() {
		JSONParser jparser = new JSONParser();// parser simple

		ArrayList<String> alist = new ArrayList<>();
		HashMap<String, String> hmap = new HashMap<>();

		hmap.put("값", "값1");
		hmap.put("값2", "값2");
		System.out.println(hmap.toString()); // map 형태 출력

		JSONObject jo = new JSONObject();
		jo.putAll(hmap); // jsonObject에 map put

		System.out.println(jo); // json 형태 map 출력

		// json array 변환법
		return "page";
	}

	@GetMapping
	public String getView() {
		// get으로 사이트 매핑 방법 찾기
		return "getView";
	}
}