package spring.project.app.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println();
		System.out.println();

		return "list";
	}
}