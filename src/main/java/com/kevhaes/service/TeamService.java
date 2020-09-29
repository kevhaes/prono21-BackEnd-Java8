/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.TeamDao;
import com.kevhaes.repository.TeamRepository;

/**
 * @author KevHaes
 *
 */
@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public List<TeamDao> findAllTeams() {
		return (List<TeamDao>) teamRepository.findAll();
	}

}
