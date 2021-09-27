package packt.springboot.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import packt.springboot.webapp.model.ProfileForm;

@Controller
@RequestMapping("/farm/users/profile")
public class UserProfileFormController {
	
	
	
	@GetMapping
	public String initForm(Model model) {
		model.addAttribute("username", "sjctrags");
		model.addAttribute("profileForm", new ProfileForm());
		return "th_users_profile";
	}
	
	@PostMapping
	public String submitForm(Model model) {
		model.addAttribute("username", "sjctrags");
		
		return "th_users_profile";
	}

}
