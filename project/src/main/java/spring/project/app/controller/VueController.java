package spring.project.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VueController {
	
	@RequestMapping(value="/vueTest.do")
	public String vueMain() {
		
		return "vuePage";
	}

}
