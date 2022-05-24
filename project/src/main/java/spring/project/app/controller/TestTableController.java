package spring.project.app.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
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

	@RequestMapping(value = "/list.do")
	public String view(Model model) throws Exception {
		List<Map<String, Object>> AllList = testtableservice.SelectAllList();
		System.out.println(AllList);
		model.addAttribute("list", AllList);
		return "list";
	}

	@RequestMapping(value = "/validation.do")
	@ResponseBody // json 형태로 반환
	public String validateID(String userid) {
		if (userid.isEmpty()) {
			return "아이디 값을 입력하세요.";
		} else {
			return userid + "는 사용가능합니다";
		}
	}
}