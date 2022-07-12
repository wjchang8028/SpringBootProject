package spring.project.app.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class apiController {

	@RequestMapping(value = "/callapi.do")
	public String CallApi(HttpServletRequest request) {

		HashMap map = new HashMap();
		
		
		return "";
	}
}
