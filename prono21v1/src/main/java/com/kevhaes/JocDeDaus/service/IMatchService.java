
/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import com.kevhaes.JocDeDaus.dto.Match;

/**
 * @author KevHaes
 *
 */
public interface IMatchService {
	public List<Match> showAllMatches();

	public Match getOneMatch(Long id);
}
