/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IBetDao;
import com.kevhaes.JocDeDaus.dto.Bet;

/**
 * @author KevHaes
 *
 */
@Service
public class BetService implements IBetService {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	IBetDao iBetDao;
	/////////////// CONSTRUCTORS ///////////////

	@Override
	public List<Bet> showAllBets() {
		return iBetDao.findAll();
	}

	@Override
	public ArrayList<Bet> showAllBetsOfOneUser(String username) {
		ArrayList<Bet> foundBets = new ArrayList<Bet>();
		if (!iBetDao.findAll().isEmpty()) {
			for (Bet bet : iBetDao.findAll()) {
				if (bet.getUser().getUsername().equals(username)) {
					foundBets.add(bet);
				}
			}
		}
		return foundBets;
	}

	@Override
	public Bet createOneBet(Bet bet) {
		return iBetDao.save(bet);
	}

	/////////////// GETTERS & SETTERS ///////////////

	/////////////// METHODS ///////////////

}
