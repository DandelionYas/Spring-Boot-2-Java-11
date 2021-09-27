package packt.springboot.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import packt.springboot.webapp.exception.EmailFormException;

@Controller
@RequestMapping("/farm/email")
public class EmailController {

    @GetMapping
    public String initForm() {
        return "tpl_email_form";
    }

    @PostMapping
    @ResponseBody
    public String submitForm(@RequestBody String email) throws EmailFormException {
        if (email.length() < 50) {
            throw new EmailFormException();
        }
        return email;
    }

    //Solution 1: having dedicated /error endpoint for each controller
    @ExceptionHandler(EmailFormException.class)
    @GetMapping("/error")
    public String submitForm(Exception e) {
        return "mst_email_exception";
    }
}
