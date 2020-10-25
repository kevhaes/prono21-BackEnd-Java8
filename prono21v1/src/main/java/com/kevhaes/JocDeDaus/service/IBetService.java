/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import com.kevhaes.JocDeDaus.dto.Bet;

/**
 * @author KevHaes
 *
 */
public interface IBetService {

	public List<Bet> showAllBets();

	public List<Bet> showAllBetsOfOneUser(String username);

	public Bet createOneBet(Bet bet);
}
