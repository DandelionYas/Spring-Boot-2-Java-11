package packt.springboot.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import packt.springboot.webapp.exception.HarvestFormException;

import java.util.Properties;

/**
Solution 2: An exception resolver class that manages exceptions at the DispatcherServlet level
  Can be Implemented through:
        ExceptionHandlerExceptionResolver
        ResponseStatusExceptionResolver
        DefaultHandlerExceptionResolver
        SimpleMappingExceptionResolver
*/
@Configuration
public class ExceptionResolverConfig {
	
	@Bean
    public SimpleMappingExceptionResolver customMappingExceptionResolver() {
    	SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.setProperty(HarvestFormException.class.getName(), "mst_harvest_exception");
       
        resolver.setExceptionMappings(mappings);
        
        resolver.addStatusCode("mst_harvest_exception", 500);
        
        resolver.setDefaultErrorView("mst_farm_generic_error");
        resolver.setExceptionAttribute("ex");
        return resolver;
    }
}