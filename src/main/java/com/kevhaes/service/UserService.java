/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.UserDao;
import com.kevhaes.repository.UserRepository;

/**
 * @author KevHaes
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDao> findAllUsers() {
		List<UserDao> foundUsers = (List<UserDao>) userRepository.findAll();
		// System.out.println("FOUND USERS ARE:" + foundUsers);
		return foundUsers;
	}

	public List<UserDao> findAllUsersRanked() {
		List<UserDao> sortedUsers = userRepository.findAllByOrderByTotalscoreDesc();
		return sortedUsers;
	}

	public void deletUser(long id) {
		userRepository.deleteById(id);
	}

//	private Sort sortByIdAsc() {
//		return new Sort(Sort.Direction.ASC, "id");
//	}

}
