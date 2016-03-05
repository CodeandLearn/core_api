package Core;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("Content-Type", "application/json; charset=UTF-8");
        container.setPort(8080);
        container.setSessionTimeout(10, TimeUnit.MINUTES);
    }
}