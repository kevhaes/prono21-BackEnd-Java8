/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Bet;
import com.kevhaes.JocDeDaus.dto.User;
import com.kevhaes.JocDeDaus.service.BetService;
import com.kevhaes.JocDeDaus.service.UserService;

/**
 * @author KevHaes
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	UserService userService;

	@Autowired
	BetService betService;

	/////////////// METHODS ///////////////
	@PostMapping
	public User createUser(@RequestBody User user) {

		return userService.createUser(user);
	}

	@GetMapping("/users")
	public List<User> showAllUsers() {
		return userService.showAllUsers();
	}

	@PostMapping("/users/auth/signin")
	public HashMap<String, Object> checkAuth(@RequestBody User userData) {
		HashMap<String, Object> authFeedback = new HashMap<>();
		authFeedback.put("feedback", userService.checkAuth(userData));

		return authFeedback;

	}

	@GetMapping("/users/{username}/bets")
	public List<Bet> showAllBetsOfOneUser(@PathVariable String username) {
		System.out.println("received request" + username);
		System.out.println(betService.showAllBetsOfOneUser("Curcio"));
		return betService.showAllBetsOfOneUser("Curcio");
	}

	@GetMapping("/{username}")
	public User get(@PathVariable String username) {
		System.out.println("received request" + username);
		return userService.findByUsername(username);
	}

}
