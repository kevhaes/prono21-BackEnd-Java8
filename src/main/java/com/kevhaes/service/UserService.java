/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.BetDao;
import com.kevhaes.model.UserDao;
import com.kevhaes.model.UserDto;
import com.kevhaes.repository.BetRepository;
import com.kevhaes.repository.UserRepository;

/**
 * @author KevHaes
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BetRepository betRepository;

	public List<UserDao> findAllUsers() {
		List<UserDao> foundUsers = (List<UserDao>) userRepository.findAll();
		return foundUsers;
	}

	public List<UserDto> findUsersRanked() {
		List<UserDao> allUsers = userRepository.findAll();
		List<UserDto> allDtoUsers = new ArrayList<>();
		for (UserDao userDao : allUsers) {
			UserDto userDto = new UserDto();
			userDto.setId(userDao.getId());
			userDto.setPoints(calculatePointsByUser(userDao));
			userDto.setImageurl(userDao.getImageurl());
			userDto.setUsername(userDao.getUsername());
			int points = calculatePointsByUser(userDao);
			userDto.setPoints(points);
			allDtoUsers.add(userDto);
		}
		return allDtoUsers;
	}

	public void deletUser(long id) {
		Long tagetUserID = userRepository.findById(id).get().getId();
		if (tagetUserID != null) {
			userRepository.deleteById(tagetUserID);
		}
	}

	public int calculatePointsByUser(UserDao userDao) {
		int points = 0;
		List<BetDao> allBets = betRepository.findAll();
		Long userId = userDao.getId();
		for (BetDao betDao : allBets) {
			if (betDao.getUser().getId() == userId) {
				points += betDao.getObtainedpoints();
			}
		}
		return points;
	}

	public UserDao showUserDetails(Long id) {
		return userRepository.findById(id).get();
	}
}
