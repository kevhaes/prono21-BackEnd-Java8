/**
 * @author KevHaes
 *
 */
package com.kevhaes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.model.UserDao;
import com.kevhaes.model.UserDto;
import com.kevhaes.service.UserService;
import com.kevhaes.service.UserStatsService;

/**
 * @author KevHaes
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserStatsService userStatsService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDao> findAllUsers() {
		List<UserDao> foundUsers = userService.findAllUsers();
		return foundUsers;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {
		// System.out.println("DELETE REQUEST: " + id);
		userService.deletUser(id);

	}

	@RequestMapping(value = "/users/{stringId}", method = RequestMethod.GET)
	public UserDao showUserDetails(@PathVariable String stringId) {
		Long longId = Long.parseLong(stringId);
		return userService.showUserDetails(longId);

	}

	@RequestMapping(value = "/usersranking", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findUsersRanked() {
		return new ResponseEntity<>(userService.findUsersRanked(), HttpStatus.OK);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void calculateTotalPointsForUser() {
		userStatsService.orderUsersByTotalObtainedPoints();
	}

}
