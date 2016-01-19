package Core.Plugin.Course;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class CourseController {
	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public Default courseList() {
		return new Default("Courses");
	}

	@RequestMapping(value = "/course/", method = RequestMethod.GET)
	public Default course(@RequestParam(value = "id") Integer id) {
		return new Default(String.valueOf(id));
	}

	@RequestMapping(value = "/course/comment/", method = RequestMethod.GET)
	public Default courseComment(@RequestParam(value = "course_id") Integer course_id) {
		return new Default(String.valueOf(course_id));
	}

	@RequestMapping(value = "/course/languages/list/", method = RequestMethod.GET)
	public Default courseLanguagesList(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name) {
		return new Default(name);
	}
}
