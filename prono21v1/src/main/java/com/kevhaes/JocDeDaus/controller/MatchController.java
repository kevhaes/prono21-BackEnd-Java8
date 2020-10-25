/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Match;
import com.kevhaes.JocDeDaus.service.MatchService;

/**
 * @author KevHaes
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/matches")
public class MatchController {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	MatchService matchService;

	/////////////// METHODS ///////////////
	@GetMapping
	public HashMap<String, Object> showAllMatches() {
		HashMap<String, Object> map = new HashMap<>();
		List<Match> foundMatches = null;
		foundMatches = matchService.showAllMatches();
		if (!foundMatches.isEmpty()) {
			map.put("success", true);
			map.put("matches", foundMatches);
		} else {
			map.put("success", false);
			map.put("message", "Something whent wrong: ");
		}
		return map;

	}

}
