/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Bet;
import com.kevhaes.JocDeDaus.service.BetService;

/**
 * @author KevHaes
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/bets")
public class BetController {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	BetService betService;

	/////////////// METHODS ///////////////
	@GetMapping
	public List<Bet> showAllBets() {
		return betService.showAllBets();
	}

	@PostMapping
	public Bet createOneBet(@RequestBody Bet bet) {
		System.out.println("bet entered: " + bet);
		return betService.createOneBet(bet);

	}

}
