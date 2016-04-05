package Core;

import Core.Tool.SQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.xml.bind.annotation.XmlElementDecl;
import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("DEBUG : " + SQL.BLOG);
        System.out.println("DEBUG : " + SQL.COMMENT);
        System.out.println("DEBUG : " + SQL.USER);
    }
}