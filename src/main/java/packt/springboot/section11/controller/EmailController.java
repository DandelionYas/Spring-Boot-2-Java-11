package packt.springboot.section11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/farm/email")
public class EmailController {

    @GetMapping
    public String initForm() {
        return "email_form";
    }

    @PostMapping
    @ResponseBody
    public String submitForm(@RequestBody String email) {
        return email;
    }
}
