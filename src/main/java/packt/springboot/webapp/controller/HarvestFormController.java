package packt.springboot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import packt.springboot.webapp.model.HarvestForm;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/farm/harvest/add")
public class HarvestFormController {
    private String projectName;
    private LocalDate localDate;
    private List<HarvestForm> dbHarvest;

    @Autowired
    public HarvestFormController(String projectName, LocalDate localDate, List<HarvestForm> dbHarvest) {
        this.projectName = projectName;
        this.localDate = localDate;
        this.dbHarvest = dbHarvest;
    }

    @GetMapping
    public String initForm(Model model) {
        model.addAttribute("projName", projectName);
        model.addAttribute("harvestForm", new HarvestForm());
        return "ftl_harvest_form";
    }

    @PostMapping
    public String submitForm(Model model, @RequestParam String name,
                             @RequestParam Integer qty,
                             @RequestParam Float price) {
        model.addAttribute("projName", projectName);
        model.addAttribute("ldate", localDate);
        HarvestForm prod = new HarvestForm();
        prod.setName(name);
        prod.setQty(qty);
        prod.setPrice(price);

        dbHarvest.add(prod);
        model.addAttribute("dbHarvest", dbHarvest);
        return "ftl_harvest_list";
    }
}
