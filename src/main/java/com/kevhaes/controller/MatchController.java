/**
 * @author KevHaes
 *
 */
package com.kevhaes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.model.MatchDao;
import com.kevhaes.model.MatchDto;
import com.kevhaes.service.MatchService;

/**
 * @author KevHaes
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class MatchController {

	@Autowired
	MatchService matchService;

	@RequestMapping(value = "/matches", method = RequestMethod.GET)
	public List<MatchDao> findAllMatches() {
		return matchService.findAllMatches();
	}

	@RequestMapping(value = "/matches", method = RequestMethod.POST)
	public MatchDao createMatch(@RequestBody MatchDto match) {
		return matchService.createMatch(match);
	}

	@RequestMapping(value = "/matches/bets/{username}", method = RequestMethod.GET)
	public ArrayList<MatchDto> getMatchesForUser(@PathVariable String username) {
		return matchService.getMatchesForUser(username);
	}

	@RequestMapping(value = "/matches/{matchId}", method = RequestMethod.GET)
	public MatchDao showMatchDetails(@PathVariable Long matchId) {
		return matchService.getMatchById(matchId);
	}

	@RequestMapping(value = "/matches/", method = RequestMethod.PUT)
	public void modifyMatch(@RequestParam("id") String id, @RequestParam("hometeamscore") String hometeamscore,
			@RequestParam("awayteamscore") String awayteamscore) {
		matchService.modifyMatch(id, hometeamscore, awayteamscore);
	}

}
