package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.UserModel;
import service.UserService;
import util.SessionUtil;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public boolean checkExistUser(@RequestBody UserModel userModel) {
		boolean ok = userService.checkUserIfExist(userModel);
		if (ok == true) {
			SessionUtil.getInstance().session().setAttribute("user", userModel);
		}

		return ok;
	}

	@RequestMapping(value = "/search/{criteria}", method = RequestMethod.GET)
	public List<String> getAllUsersByCriteria(@PathVariable String criteria) {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");

		if (userModel != null) {
			return this.userService.getUsernameByCriteria(criteria);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		SessionUtil.getInstance().session().invalidate();
	}

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public ResponseEntity<List<UserModel>> getUserFriends() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");

		if (userModel == null) {
			return ResponseEntity.status(HttpStatus.LOCKED).body(null);
		}

		return ResponseEntity.ok(userService.getUserFriends(userModel));
	}

	@RequestMapping(value = "/friendsRequest", method = RequestMethod.GET)
	public ResponseEntity<List<UserModel>> getUserFriendsRquest() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");

		if (userModel == null) {
			return ResponseEntity.status(HttpStatus.LOCKED).body(null);
		}

		return ResponseEntity.ok(userService.getUserFriendsRequest(userModel));
	}
	
	@RequestMapping(value = "/friendsRequest/{username}", method = RequestMethod.POST)
	public void getUserFriendsRquest(@PathVariable String username) {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");

		if (userModel != null) {
			
		}
	}
}
