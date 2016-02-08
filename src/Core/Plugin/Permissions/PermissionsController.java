package Core.Plugin.Permissions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class PermissionsController {
	@RequestMapping(value = "/permissions/", method = RequestMethod.GET)
	public Default permissions(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/permissions/groupid/", method = RequestMethod.GET)
	public Default permissionsGroupId(@RequestParam(value = "groupid") Integer groupid, HttpServletRequest request) {
		return new Default(request);
	}
}
