package Core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*ApplicationContext app = SpringApplication.run(Application.class, args);
        System.out.println("Loaded :");
        String[] beanNames = app.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
        SpringApplication.run(Application.class, args);
    }
}