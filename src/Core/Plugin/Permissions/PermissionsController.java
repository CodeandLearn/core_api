package Core.Plugin.Permissions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class PermissionsController {
	@RequestMapping(value = "/permissions/", method = RequestMethod.GET)
	public Default permissions(@RequestParam(value = "id") Integer id) {
		return new Default(String.valueOf(id));
	}

	@RequestMapping(value = "/permissions/groupid/", method = RequestMethod.GET)
	public Default permissionsGroupId(@RequestParam(value = "groupid") Integer groupid) {
		return new Default(String.valueOf(groupid));
	}
}
