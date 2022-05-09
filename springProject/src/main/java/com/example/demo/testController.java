package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "")

public class testController {
	@Autowired
	testService testservice;

	@RequestMapping(value = "/main.do")
	public String testMethod(String a,Model model) {
		System.out.println(a);
		model.addAttribute("a", a);
		return "main";
	}

}
