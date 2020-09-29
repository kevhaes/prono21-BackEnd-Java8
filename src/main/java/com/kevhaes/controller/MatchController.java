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
		System.out.println("GET REQUEST MATCHES RECEIVED");
		return matchService.findAllMatches();
	}

	@RequestMapping(value = "/matches", method = RequestMethod.POST)
	public MatchDao createMatch(@RequestBody MatchDto match) {
		System.out.println("Create Match REQUEST RECEIVED" + match);
		return matchService.createMatch(match);
	}

	@RequestMapping(value = "/matches/{username}", method = RequestMethod.GET)
	public ArrayList<MatchDto> getMatchesForUser(@PathVariable String username) {
		System.out.println("GET REQUEST getMatchesForUser RECEIVED for " + username);
		return matchService.getMatchesForUser(username);
	}

	@RequestMapping(value = "/matches/{matchId}", method = RequestMethod.PUT)
	public void closeMatch(@PathVariable Long matchId) {
		System.out.println("close match request for" + matchId);
		matchService.closeMatch(matchId);
	}

}
