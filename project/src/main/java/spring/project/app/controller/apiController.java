package spring.project.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class apiController {

	@RequestMapping(value = "/callapi.do")
	public String CallApi() {

		return "";
	}
}
