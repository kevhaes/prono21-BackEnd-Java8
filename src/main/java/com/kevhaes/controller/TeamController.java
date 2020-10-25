/**
 * @author KevHaes
 *
 */
package com.kevhaes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.model.TeamDao;
import com.kevhaes.service.TeamService;

/**
 * @author KevHaes
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class TeamController {

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public List<TeamDao> findAllTeams() {
		// System.out.println("GETTEAMS REQUEST received");
		return teamService.findAllTeams();
	}

}
