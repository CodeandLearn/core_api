package Core.Tool;

/**
 * Created by teddy on 03/04/2016.
 */
public class SQL {
    public static String BLOG = "SELECT (SELECT COUNT(id) FROM blog_posts)'nb', * FROM blog_posts ORDER BY id DESC";
    public static String USER = "";
}
