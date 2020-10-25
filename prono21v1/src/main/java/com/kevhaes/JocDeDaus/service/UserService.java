/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IUserDao;
import com.kevhaes.JocDeDaus.dto.User;

/**
 * @author KevHaes
 *
 */
@Service
public class UserService implements IUserService {

	/////////////// ATRIBUTES ///////////////
	@Autowired
	IUserDao iUserDao;
	/////////////// METHODS ///////////////

	@Override
	public List<User> showAllUsers() {
		return iUserDao.findAll();
	}

	@Override
	public HashMap<String, Object> checkAuth(User userData) {
		System.out.println("checkUath started");
		HashMap<String, Object> feedback = new HashMap<>();
		Boolean isAuthorized = false;
		if (!iUserDao.findAll().isEmpty()) {
			for (User user : iUserDao.findAll()) {
				System.out.println(user);
				if (user.getUsername().equals(userData.getUsername())
						&& user.getPassword().equals(userData.getPassword())) {
					isAuthorized = true;
					feedback.put("user", user);
				}
			}
		}
		feedback.put("authorized", isAuthorized);
		return feedback;
	}

	@Override
	public User findByUsername(String username) {
		User foundUser = null;
		for (User user : iUserDao.findAll()) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				foundUser = user;
				return foundUser;
			}

		}
		return foundUser;

	}

	@Override
	public User createUser(User user) {
		return iUserDao.save(user);
	}
}
