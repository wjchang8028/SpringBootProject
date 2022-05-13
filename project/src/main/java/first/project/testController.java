package first.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping(value = "/main.do")
	public String start(Model model) {

		model.addAttribute("a", "new!");
		return "test";
	}

}
