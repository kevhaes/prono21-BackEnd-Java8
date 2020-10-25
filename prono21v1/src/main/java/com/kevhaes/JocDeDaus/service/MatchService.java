/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IMatchDao;
import com.kevhaes.JocDeDaus.dto.Match;

/**
 * @author KevHaes
 *
 */
@Service
public class MatchService implements IMatchService {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	IMatchDao iMatchDao;
	/////////////// CONSTRUCTORS ///////////////

	@Override
	public List<Match> showAllMatches() {
		return iMatchDao.findAll();
	}

	@Override
	public Match getOneMatch(Long id) {
		return iMatchDao.findById(id).get();
	}

	/////////////// GETTERS & SETTERS ///////////////

	/////////////// METHODS ///////////////

	/////////////// TOSTRING ///////////////

}
