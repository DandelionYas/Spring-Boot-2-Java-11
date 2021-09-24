package packt.springboot.section11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
}
