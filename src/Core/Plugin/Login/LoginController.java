package Core.Plugin.Login;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Hello.Hello;

@RestController
public class LoginController {
	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	@Secured("ROLE_USER")
	public Hello hello(@PathVariable String username, @PathVariable String password,
			AuthenticationManagerBuilder auth) {
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		return new Hello(1, "test");
	}
}

/*
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class UserAuth {
	private String timestamp;
	private String username;
	private String password;
	private String token;
	private int ttl;
	
	public UserAuth(String timestamp, String username, String pwd, String token) {
		this.timestamp = timestamp;
		this.username = username;
		this.password = pwd;
		this.token = token;
		this.ttl = 3600;
	}
	
	public String getTimestamp() {
		return this.timestamp;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public int getTtl() {
		return this.ttl;
	}
	
	public void setTtl(int newTtl) {
		this.ttl = newTtl;
	}
}

@RestController
public class Login {
	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	public UserAuth userAuth(@PathVariable String username, @PathVariable String password) {
		String hashpwd = hashString(password, "MD5");
		String token = UUID.randomUUID.toString().replaceAll("-","");
		String timestamp = new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss").format(new Date());
		return new UserAuth(timestamp, username, hashpwd, token);
	}
}
*/