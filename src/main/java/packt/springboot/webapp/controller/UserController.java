package packt.springboot.webapp.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@Autowired
	private String webmaster;

	@GetMapping("/farm/providers")
	public String listProviders(Model model) {
		model.addAttribute("users", Arrays.asList("sjctrags", "root", "guest"));
		return "th_providers";
	}
}
