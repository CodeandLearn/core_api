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
