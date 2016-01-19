package Core.Plugin.Blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class BlogController {
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public Default blog() {
		return new Default("Blog");
	}
}
