package packt.springboot.section11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;

@Lazy
@Configuration
public class LazyBeanConfiguration {

    @Bean
    public LocalDate localDate() {
        return LocalDate.now();
    }

    @Bean
    public String webmaster() {
        return "yaser.ghaderipour@gmail.com";
    }
}
