package Core;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.*;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
		mappings.add("Content-Type", "application/json; charset=UTF-8");
		container.setPort(8080);
		container.setSessionTimeout(10, TimeUnit.MINUTES);
		// container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
		// "/notfound.html"));
	}
}