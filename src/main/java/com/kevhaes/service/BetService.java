/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.ArrayList;
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
		newBetDao.setMatch(match);
		newBetDao.setUser(user);
		newBetDao.setHometeambet(bet.getHomeTeamBet());
		newBetDao.setAwayteambet(bet.getAwayTeamBet());

		return betRepository.save(newBetDao);
	}

	/// methods
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

	public List<BetDao> showAllBets() {
		return betRepository.findAll();
	}

	public List<BetDao> showAllBetsForMatchById(Long matchId) {
		List<BetDao> allBets = betRepository.findAll();
		List<BetDao> allBetsForThisMatch = new ArrayList<>();

		for (BetDao betDao : allBets) {
			if (betDao.getMatch().getId().equals(matchId)) {
				allBetsForThisMatch.add(betDao);
			}
		}
		return allBetsForThisMatch;
	}
}