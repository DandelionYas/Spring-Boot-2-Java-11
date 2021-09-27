package packt.springboot.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import packt.springboot.webapp.model.Harvest;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public String  projectName() {
        return "FarmUp Harvester";
    }

    @Lazy
    @Bean
    public String tabName() {
        return "FarmUp";
    }

    @Bean
    public List<Harvest> dbHarvest() {
        return new ArrayList();
    }
}
