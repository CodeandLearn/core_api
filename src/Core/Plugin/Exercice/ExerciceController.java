package Core.Plugin.Exercice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class ExerciceController {
	@RequestMapping(value = "/exercice/", method = RequestMethod.GET)
	public Default exercice(@RequestParam(value = "id") Integer id) {
		return new Default(String.valueOf(id));
	}

	@RequestMapping(value = "/exercice/comment/", method = RequestMethod.GET)
	public Default exerciceComment(@RequestParam(value = "exercice_id") Integer exercice_id) {
		return new Default(String.valueOf(exercice_id));
	}

	@RequestMapping(value = "/exercice/correction/", method = RequestMethod.GET)
	public Default exerciceCorrection(@RequestParam(value = "exercice_id") Integer exercice_id,
			@RequestParam(value = "token") Integer token) {
		return new Default(String.valueOf(exercice_id));
	}

	@RequestMapping(value = "/exercice/user_code/", method = RequestMethod.GET)
	public Default exerciceUserCode(@RequestParam(value = "exercice_id") Integer exercice_id,
			@RequestParam(value = "author_id") Integer author_id, @RequestParam(value = "token") Integer token) {
		return new Default(String.valueOf(exercice_id));
	}
}
