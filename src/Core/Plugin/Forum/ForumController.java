package Core.Plugin.Forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class ForumController {
	@RequestMapping(value = "/forum/forum", method = RequestMethod.GET)
	public Default forumForum(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/forum/subject/", method = RequestMethod.GET)
	public Default forumSubjects(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/forum/categories/", method = RequestMethod.GET)
	public Default forumCategories(@RequestParam(value = "id_forum") Integer id_forum, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/forum/posts/", method = RequestMethod.GET)
	public Default forumPosts(@RequestParam(value = "id_subject") Integer id_subject,
			@RequestParam(value = "token") Integer token, HttpServletRequest request) {
		return new Default(request);
	}
}
