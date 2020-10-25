/**
 * @author KevHaes
 *
 */
package com.kevhaes.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.model.BetDao;
import com.kevhaes.model.BetDto;
import com.kevhaes.service.BetService;

/**
 * @author KevHaes
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class BetController {

	@Autowired
	private BetService betService;

	@RequestMapping(value = "/bets", method = RequestMethod.POST)
	public BetDto createBet(@RequestBody BetDto bet) {

		// receive answer betDao from service
		BetDao betDao = betService.createBet(bet);

		// create response betDto and fill
		BetDto betDto = new BetDto();
		betDto.setHomeTeamBet(betDao.getHometeambet());
		betDto.setAwayTeamBet(betDao.getAwayteambet());
		betDto.setMatch(betDao.getMatch().getId());

		return betDto;
	}

	@RequestMapping(value = "/bets", method = RequestMethod.GET)
	public ArrayList<BetDao> showAllBets() {
		return new ArrayList<>(betService.showAllBets());

	}

	@RequestMapping(value = "/matches/{matchId}/bets", method = RequestMethod.GET)
	public ArrayList<BetDao> showAllBetsForMatchById(@PathVariable Long matchId) {
		return (ArrayList<BetDao>) betService.showAllBetsForMatchById(matchId);

	}
}
