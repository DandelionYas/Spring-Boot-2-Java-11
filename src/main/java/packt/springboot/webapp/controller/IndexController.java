package packt.springboot.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farm")
public class IndexController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to FarmUp! Let us message, harvest and enjoy our gains!";
    }
}
