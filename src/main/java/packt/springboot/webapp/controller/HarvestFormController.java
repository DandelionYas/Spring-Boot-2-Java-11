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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        Map<String, String> types = new LinkedHashMap<>();
        types.put("veggie", "Vegetable");
        types.put("fruit", "Fruit");

        Map<String, String> status = new LinkedHashMap<>();
        status.put("ok", "OK");
        status.put("expired", "EXPIRED");
        model.addAttribute("types", types);
        model.addAttribute("status", status);
        model.addAttribute("harvestForm", new HarvestForm());
        return "ftl_harvest_form";
    }

    @PostMapping
    public String submitForm(Model model, @RequestParam Integer id, @RequestParam String name,
                             @RequestParam Integer qty, @RequestParam String description,
                             @RequestParam Float price, @RequestParam String deliveryDate,
                             @RequestParam String location, @RequestParam String owner, @RequestParam String type,
                             @RequestParam String status) {
        model.addAttribute("projName", projectName);
        model.addAttribute("ldate", localDate);
        model.addAttribute("header", "List of Harvest");
        HarvestForm prod = new HarvestForm();
        prod.setId(id);
        prod.setName(name);
        prod.setQty(qty);
        prod.setPrice(price);
        prod.setDescription(description);
        prod.setDeliveryDate(deliveryDate);
        prod.setOwner(owner);
        prod.setLocation(location);
        prod.setStatus(status);
        prod.setType(type);

        dbHarvest.add(prod);
        model.addAttribute("harvest", dbHarvest);
        return "ftl_harvest_list";
    }
}
