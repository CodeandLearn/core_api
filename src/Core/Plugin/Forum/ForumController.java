package Core.Plugin.Forum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class ForumController {
	@RequestMapping(value = "/forum/forum", method = RequestMethod.GET)
	public Default forumForum() {
		return new Default("ForumForum");
	}

	@RequestMapping(value = "/forum/subject/", method = RequestMethod.GET)
	public Default forumSubjects(@RequestParam(value = "id") Integer id) {
		return new Default(String.valueOf(id));
	}

	@RequestMapping(value = "/forum/categories/", method = RequestMethod.GET)
	public Default forumCategories(@RequestParam(value = "id_forum") Integer id_forum) {
		return new Default(String.valueOf(id_forum));
	}

	@RequestMapping(value = "/forum/posts/", method = RequestMethod.GET)
	public Default forumPosts(@RequestParam(value = "id_subject") Integer id_subject,
			@RequestParam(value = "token") Integer token) {
		return new Default(String.valueOf(id_subject));
	}
}
