package spring.project.app.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("list", AllList);
		return "list";
	}

	@RequestMapping(value = "/validation.do") // 아이디 사용가능한지 여부 확인 예정
	@ResponseBody // json 형태로 반환
	public String validateID(String userid) throws Exception {

		int checkID = testtableservice.SelectCheckID(userid);

		if (checkID != 0) {
			return "이미 사용중인 아이디입니다.";
		} else {
			return userid + "는 사용가능한 아이디입니다";
		}
	}

	@RequestMapping(value = "/apitest.do") //api컨트롤러 추가
	public String page() {
		return "apitest";
	}
	
	@RequestMapping
	public String jsonpage() {
		JSONParser jparser = new JSONParser();//
		
		return "page";
	}
}