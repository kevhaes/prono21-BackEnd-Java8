/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Team;
import com.kevhaes.JocDeDaus.service.TeamService;

/**
 * @author KevHaes
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/teams")
public class TeamController {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	TeamService teamService;
	/////////////// CONSTRUCTORS ///////////////

	/////////////// GETTERS & SETTERS ///////////////

	/////////////// METHODS ///////////////
	@GetMapping
	public List<Team> showAllTeams() {
		return teamService.showAllTeams();
	}
	/////////////// TOSTRING ///////////////

}
