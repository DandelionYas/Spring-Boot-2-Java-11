package packt.springboot.section11.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farm")
public class LoginController {

    @GetMapping("/login/guest")
    public String loginGuest(@RequestParam("user") String username, @RequestParam("pass") String password) {
        return  "Welcome to FarmUp, guest " + username + "!";
    }

    @PostMapping("/login/auth")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        return  "Welcome to FarmUp, member " + username + "!";
    }

    @GetMapping("/login/role/{user}")
    public String variableUserRole(@PathVariable("user") String username) {
        return "User: " + username + " is an Administrator";
    }

    @PostMapping("/login/role/{user}/{pwd:[A-Za-z0-9@$_]{3,20}}")
    public String generatePassPhrase(@PathVariable("user") String username, @PathVariable("pwd") String password) {
        return new StringBuilder(String.join("", username, password)).reverse().toString();
    }
}
