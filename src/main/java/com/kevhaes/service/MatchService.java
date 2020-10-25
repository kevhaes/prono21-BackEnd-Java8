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
import com.kevhaes.repository.BetRepository;
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

	@Autowired
	private BetRepository betRepository;

//	@Autowired
//	private UserStatsService userStatsService;

	public List<MatchDao> findAllMatches() {
		List<MatchDao> foundMatches = (List<MatchDao>) matchRepository.findAll();
		return foundMatches;
	}

	public MatchDao createMatch(MatchDto match) {
		MatchDao newMatch = new MatchDao();
		TeamDao homeTeam = teamRepository.findByName(match.getHometeam().getName());
		// System.out.println("hometeam:" + homeTeam);
		TeamDao awayTeam = teamRepository.findByName(match.getAwayteam().getName());
		newMatch.setHometeam(homeTeam);
		newMatch.setAwayteam(awayTeam);
		newMatch.setMatchdate(match.getMatchdate());
		newMatch.setStatus(match.getStatus());
		return matchRepository.save(newMatch);

	}

	public ArrayList<MatchDto> getMatchesForUser(String username) {
		ArrayList<MatchDto> returnMatches = new ArrayList<>();
		List<MatchDao> allDaoMatches = matchRepository.findAll();
		for (MatchDao matchDao : allDaoMatches) {
			MatchDto matchDto = new MatchDto();
			matchDto.setId(matchDao.getId());
			matchDto.setMatchdate(matchDao.getMatchdate());
			matchDto.setHometeam(matchDao.getHometeam());
			matchDto.setAwayteam(matchDao.getAwayteam());
			matchDto.setAwayteamscore(matchDao.getAwayteamscore());
			matchDto.setHometeamscore(matchDao.getHometeamscore());
			matchDto.setStatus(matchDao.getStatus());

			List<BetDao> allBetDaosOfMatch = matchDao.getBets();
			if (!allBetDaosOfMatch.isEmpty()) {
				for (BetDao bet : allBetDaosOfMatch) {
					if (bet.getUser().getUsername().equals(username)) {
						matchDto.setHasBet(true);
						matchDto.setHomeBet(bet.getHometeambet());
						matchDto.setAwayBet(bet.getAwayteambet());
						matchDto.setObtainedpoints(bet.getObtainedpoints());
					}
				}
			}
			returnMatches.add(matchDto);
		}
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

	// admin changes score
	public void modifyMatch(String id, String hometeamscore, String awayteamscore) {
		Long longId = Long.parseLong(id);
		MatchDao matchToModify = matchRepository.findById(longId).get();
		int intHometeamscore = Integer.parseInt(hometeamscore);
		int intAwayteamscore = Integer.parseInt(awayteamscore);

		// modify score in match
		matchToModify.setHometeamscore(intHometeamscore);
		matchToModify.setAwayteamscore(intAwayteamscore);
		matchRepository.save(matchToModify);

		// modify obtained points for bets
		if (!matchToModify.getBets().isEmpty()) {
			for (BetDao bet : matchToModify.getBets()) {
				try {
					BetDao betDao = betRepository.findById(bet.getId()).get();
					// System.out.println("found betDao: " + betDao);
					int newObtainedpoints = calculateObtainedPoints(intHometeamscore, intAwayteamscore,
							bet.getHometeambet(), bet.getAwayteambet());
					betDao.setObtainedpoints(newObtainedpoints);
					betRepository.save(betDao);
					// System.out.println("changed betDao" + betDao);
				} catch (Exception e) {
					System.out.println("no bet");
				}
			}
		}

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

	public MatchDao getMatchById(Long matchId) {
		return matchRepository.findById(matchId).get();
	}
}
