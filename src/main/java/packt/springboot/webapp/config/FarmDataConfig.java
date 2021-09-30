package packt.springboot.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import packt.springboot.webapp.model.Profile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Configuration
public class FarmDataConfig {

	@Bean
	public List<Profile> users(){
		List<Profile> dbUser = new ArrayList<>();
		Profile p1 = new Profile();
		p1.setName("Anna Bern");
		p1.setMobile("639399992233");
		p1.setAddress("France");
		p1.setEmail("abern@gmail.com");
		p1.setApproved(false);
		p1.setUsername("abern");
		p1.setPassword("bernie@2");
		p1.setBday(Calendar.getInstance());
		
		Profile p2 = new Profile();
		p2.setName("Julia Robbie");
		p2.setMobile("639398881111");
		p2.setAddress("Peru");
		p2.setEmail("jrob@gmail.com");
		p2.setApproved(true);
		p2.setUsername("jrobbie");
		p2.setPassword("jrobbie@8");
		p2.setBday(Calendar.getInstance());
		
		dbUser.add(p1);
		dbUser.add(p2);
		
		return dbUser;
	}

	
}