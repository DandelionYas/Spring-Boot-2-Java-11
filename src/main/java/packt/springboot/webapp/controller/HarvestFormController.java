package packt.springboot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import packt.springboot.webapp.model.Harvest;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/farm/harvest/add")
public class HarvestFormController {
    private String projectName;
    private LocalDate localDate;
    private List<Harvest> dbHarvest;

    @Autowired
    public HarvestFormController(String projectName, LocalDate localDate, List<Harvest> dbHarvest) {
        this.projectName = projectName;
        this.localDate = localDate;
        this.dbHarvest = dbHarvest;
    }

    @GetMapping
    public String initForm(Model model) {
        model.addAttribute("projName", projectName);
        return "harvest_from";
    }

    @PostMapping
    public String submitForm(Model model, @RequestParam String name,
                             @RequestParam Integer quality, @RequestParam Float price) {
        model.addAttribute("projName", projectName);
        model.addAttribute("lDate", localDate);
        Harvest product = new Harvest();
        product.setName(name);
        product.setQuality(quality);
        product.setPrice(price);
        dbHarvest.add(product);
        model.addAttribute("dbHarvest", dbHarvest);
        return "harvest_list";
    }
}
