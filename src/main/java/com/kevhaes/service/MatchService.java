/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.BetDao;
import com.kevhaes.model.MatchDao;
import com.kevhaes.model.MatchDto;
import com.kevhaes.model.TeamDao;
import com.kevhaes.repository.MatchRepository;
import com.kevhaes.repository.TeamRepository;

/**
 * @author KevHaes
 *
 */
@Service
public class MatchService {
	@Autowired
	private MatchRepository matchRepository;
	@Autowired
	private TeamRepository teamRepository;

	public List<MatchDao> findAllMatches() {
		List<MatchDao> foundMatches = (List<MatchDao>) matchRepository.findAll();
		return foundMatches;
	}

	public MatchDao createMatch(MatchDto match) {
		MatchDao newMatch = new MatchDao();
		TeamDao homeTeam = teamRepository.findByName(match.getHometeam().getName());
		System.out.println("hometeam:" + homeTeam);
		TeamDao awayTeam = teamRepository.findByName(match.getAwayteam().getName());
		newMatch.setHometeam(homeTeam);
		newMatch.setAwayteam(awayTeam);
		newMatch.setMatchdate(match.getMatchdate());
		newMatch.setStatus(match.getStatus());
		return matchRepository.save(newMatch);

	}

	public ArrayList<MatchDto> getMatchesForUser(String username) {
		// ArrayList<MatchDto> allMatchesForUser = convertAllDaoMatchesToDto();
		ArrayList<MatchDto> returnMatches = new ArrayList<>();

		for (MatchDao matchDao : matchRepository.findAll()) {
			// look for bets of user
			MatchDto matchDto = new MatchDto();

			matchDto.setId(matchDao.getId());
			matchDto.setMatchdate(matchDao.getMatchdate());
			matchDto.setHometeam(matchDao.getHometeam());
			matchDto.setAwayteam(matchDao.getAwayteam());
			matchDto.setAwayteamscore(matchDao.getAwayteamscore());
			matchDto.setHometeamscore(matchDao.getHometeamscore());
			matchDto.setStatus(matchDao.getStatus());
			if (!matchDao.getBets().isEmpty()) {
				for (BetDao bet : matchDao.getBets()) {
					if (username != null && bet.getUser().getUsername().equals(username)) {
						matchDto.setHasBet(true);
						matchDto.setHomeBet(bet.getHometeambet());
						matchDto.setAwayBet(bet.getAwayteambet());
						System.out.println("MATCHSERVICE getMatchesForUser added TRUE matchDto" + matchDto);
						returnMatches.add(matchDto);
					} else {
						System.out.println(
								"MATCHSERVICE getMatchesForUser added FALSE (not this userBet)matchDto" + matchDto);
						returnMatches.add(matchDto);
					}
				}
			} else {
				System.out.println("MATCHSERVICE getMatchesForUser added FALSE  (bets are empty) matchDto" + matchDto);
				returnMatches.add(matchDto);
			}
		}
		System.out.println("all returned matches:" + returnMatches);
		return returnMatches;
	}

	// converting all DAO matches to Dto matches
	public ArrayList<MatchDto> convertAllDaoMatchesToDto() {
		ArrayList<MatchDto> resultArray = new ArrayList<>();
		for (MatchDao match : matchRepository.findAll()) {
			MatchDto matchDto = new MatchDto();
			BeanUtils.copyProperties(match, matchDto);
			resultArray.add(matchDto);
		}
		System.out.println("converted all matches to DTO:" + resultArray);
		return resultArray;
	}

	// close match + adding obtained points to every bet //
	public void closeMatch(Long MatchId) {
		MatchDao match = matchRepository.findById(MatchId).get();
		int matchHomeScore = match.getHometeamscore();
		int matchAwayScore = match.getAwayteamscore();

		// set for every bet obtained points
		if (!match.getBets().isEmpty()) {
			for (BetDao bet : match.getBets()) {
				int obtainedPoints = BetService.calculateObtainedPoints(matchHomeScore, matchAwayScore,
						bet.getHometeambet(), bet.getAwayteambet());
				bet.setObtainedpoints(obtainedPoints);
			}
		}

		// close match
		match.setStatus(3);

	}

}
