package packt.springboot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/farm/home")
public class HomeController {
    private final String webmaster;
    private final String projectName;
    private final LocalDate localDate;

    @Autowired
    public HomeController(String webmaster, String projectName, LocalDate localDate) {
        this.webmaster = webmaster;
        this.projectName = projectName;
        this.localDate = localDate;
    }

    @GetMapping("/header")
    public String showHeader() {
        return projectName;
    }

    @PostMapping("/accessDate")
    public String accessDate() {
        return localDate.format(DateTimeFormatter.ofPattern("MMMM dd yyyy"));
    }

    @GetMapping("/footer")
    public String showFooter() {
        return String.join(" ",  "Contact Administrator @ ", webmaster);
    }
}
