package packt.springboot.webapp.model;

import lombok.Data;

@Data
public class ProfileForm {
	private String name;
	private String mobile;
	private String address;
	private String email;
	private String username;
	private String password;
}
