/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.BetDao;
import com.kevhaes.model.BetDto;
import com.kevhaes.model.MatchDao;
import com.kevhaes.model.UserDao;
import com.kevhaes.repository.BetRepository;
import com.kevhaes.repository.MatchRepository;
import com.kevhaes.repository.UserRepository;

/**
 * @author KevHaes
 *
 */
@Service
public class BetService {

	@Autowired
	private BetRepository betRepository;
	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private UserRepository userRepository;

	public BetDao createBet(BetDto bet) {
		// get match from
		MatchDao match = matchRepository.getOne(bet.getMatch_id());
		UserDao user = userRepository.findByUsername(bet.getUser_id());

		BetDao newBetDao = new BetDao();
		System.out.println("createBet : found MatchDao match in createBet : " + match);
		newBetDao.setMatch(match);
		newBetDao.setUser(user);
		newBetDao.setHometeambet(bet.getHomeTeamBet());
		newBetDao.setAwayteambet(bet.getAwayTeamBet());
		System.out.println("createBet : newBet in createBet :" + newBetDao);

		return betRepository.save(newBetDao);
	}

	public boolean matchHasBets(MatchDao match) {
		boolean response = false;
		if (match.getBets().size() > 0) {
			response = true;
		}
		return response;
	}

	public boolean isUserAuthor(BetDao bet, String username) {
		boolean response = false;
		if (bet.getUser().getUsername().equals(username)) {
			response = true;
		}
		return response;
	}

	public static int calculateObtainedPoints(int homeScore, int awayScore, int homeBet, int awayBet) {
		int obtainedpoints = 0;
		// guest exact result
		if (homeScore == homeBet && awayScore == awayBet) {
			obtainedpoints = 5;
			// guest 1 x exact goals of 1 team
		} else if (homeScore == homeBet || awayScore == awayBet) {
			obtainedpoints = 3;
			// guest the winner
		} else if ((homeScore > awayScore && homeBet < awayBet) || (homeScore > awayScore && homeBet > awayBet)
				|| (homeScore == awayScore && homeBet == awayBet)) {
			obtainedpoints = 2;
		}
		return obtainedpoints;
	}

	public List<BetDao> showAllBets() {

		return betRepository.findAll();
	}
}