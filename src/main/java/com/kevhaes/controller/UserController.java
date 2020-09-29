/**
 * @author KevHaes
 *
 */
package com.kevhaes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.model.UserDao;
import com.kevhaes.service.UserService;

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

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDao> findAllUsers() {
		List<UserDao> foundUsers = userService.findAllUsers();
		System.out.println("RETURNED USERS :" + foundUsers);
		return foundUsers;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {
		System.out.println("DELETE REQUEST: " + id);
		userService.deletUser(id);

	}

	@RequestMapping(value = "/usersranking", method = RequestMethod.GET)
	public List<UserDao> findAllUsersRanked() {
		List<UserDao> foundUsersRanked = userService.findAllUsersRanked();
		return foundUsersRanked;
	}

}
