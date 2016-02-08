package Core.Plugin.Exercice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class ExerciceController {
	@RequestMapping(value = "/exercice/", method = RequestMethod.GET)
	public Default exercice(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/exercice/comment/", method = RequestMethod.GET)
	public Default exerciceComment(@RequestParam(value = "exercice_id") Integer exercice_id,
			HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/exercice/correction/", method = RequestMethod.GET)
	public Default exerciceCorrection(@RequestParam(value = "exercice_id") Integer exercice_id,
			@RequestParam(value = "token") Integer token, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/exercice/user_code/", method = RequestMethod.GET)
	public Default exerciceUserCode(@RequestParam(value = "exercice_id") Integer exercice_id,
			@RequestParam(value = "author_id") Integer author_id, @RequestParam(value = "token") Integer token,
			HttpServletRequest request) {
		return new Default(request);
	}
}
