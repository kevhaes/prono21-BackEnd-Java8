/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.UserDao;
import com.kevhaes.model.UserStats;
import com.kevhaes.repository.UserRepository;
import com.kevhaes.repository.UserStatsReposirory;

/**
 * @author KevHaes
 *
 */
@Service
public class UserStatsService {

	@Autowired
	private UserStatsReposirory userStatsReposirory;

	@Autowired
	private UserRepository userRepository;

	public List<UserStats> orderUsersByTotalObtainedPoints() {
		List<UserStats> allUserstats = userStatsReposirory.findAll();
		System.out.println("allUserstats: " + allUserstats);
		Collections.sort(allUserstats, Comparator.comparing(UserStats::getPoints));
		return allUserstats;
	}

	public void createUserStats() {
		for (UserDao userDao : userRepository.findAll()) {

			// userDao.setUserStats(userStats)
		}

	}

}
