package spring.project.app.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class apiController {

	@RequestMapping(value = "/callapi.do")
	public String CallApi(HttpServletRequest request) {

		HashMap map = new HashMap();
		
		HttpClient client = HttpClientBuilder.create().build();
		
		
		return "";
	}
	
	
	
	public String apiinit(HttpServletRequest request) {
		
		request.getParameter(null);
		
		return "";
	}
}
