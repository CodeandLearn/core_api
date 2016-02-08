package Core.Plugin.Course;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class CourseController {
	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public Default courseList(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/course/", method = RequestMethod.GET)
	public Default course(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/course/comment/", method = RequestMethod.GET)
	public Default courseComment(@RequestParam(value = "course_id") Integer course_id, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/course/languages/list/", method = RequestMethod.GET)
	public Default courseLanguagesList(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name, HttpServletRequest request) {
		return new Default(request);
	}
}
