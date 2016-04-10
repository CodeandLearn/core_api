package Core;

import Core.Datas.SQLGet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("\nDEBUG GET BLOG : " + SQLGet.BLOG);
        System.out.println("\nDEBUG GET BLOG_POST : " + SQLGet.BLOG_POST);
        System.out.println("\nDEBUG GET BLOG_COMMENT : " + SQLGet.BLOG_COMMENT);
        System.out.println("\nDEBUG GET BLOG_CATEGORY : " + SQLGet.BLOG_CATEGORY);
        System.out.println("\nDEBUG GET ACCOUNT : " + SQLGet.ACCOUNT);
        System.out.println("\nDEBUG GET ACCOUNT_AVATAR : " + SQLGet.ACCOUNT_AVATAR);
        System.out.println("\nDEBUG GET ACCOUNT_GROUP : " + SQLGet.ACCOUNT_GROUP);
    }
}