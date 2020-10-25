/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.HashMap;
import java.util.List;

import com.kevhaes.JocDeDaus.dto.User;

/**
 * @author KevHaes
 *
 */
public interface IUserService {
	public List<User> showAllUsers();

	public User findByUsername(String username);

	public User createUser(User user);

	public HashMap<String, Object> checkAuth(User userData);
}
