/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.ITeamDao;
import com.kevhaes.JocDeDaus.dto.Team;

/**
 * @author KevHaes
 *
 */
@Service
public class TeamService implements ITeamService {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	ITeamDao iTeamDao;
	/////////////// CONSTRUCTORS ///////////////

	@Override
	public List<Team> showAllTeams() {
		return iTeamDao.findAll();
	}

	/////////////// GETTERS & SETTERS ///////////////

	/////////////// METHODS ///////////////

	/////////////// TOSTRING ///////////////

}
