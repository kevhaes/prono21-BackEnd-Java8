/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author KevHaes
 *
 */
public class MatchDto {
	/////////////// ATRIBUTES ///////////////
	private Long id;
	private TeamDao hometeam;
	private TeamDao awayteam;
	private int hometeamscore;
	private int awayteamscore;
	private Date matchdate;
	private int status;
	private List<BetDao> bets;

	private boolean hasBet = false;
	private int homeBet = -1;
	private int awayBet = -1;
	private int obtainedpoints = 0;

	/////////////// CONSTRUCTORS ///////////////

	public MatchDto(Long id, TeamDao hometeam, TeamDao awayteam, int hometeamscore, int awayteamscore, Date matchdate,
			int status, List<BetDao> bets, boolean hasBet, int homeBet, int awayBet, int obtainedpoints) {
		super();
		this.id = id;
		this.hometeam = hometeam;
		this.awayteam = awayteam;
		this.hometeamscore = hometeamscore;
		this.awayteamscore = awayteamscore;
		this.matchdate = matchdate;
		this.status = status;
		this.bets = bets;
		this.hasBet = hasBet;
		this.homeBet = homeBet;
		this.awayBet = awayBet;
		this.obtainedpoints = obtainedpoints;
	}

	public MatchDto() {
		super();
	}

	/////////////// GETTERS & SETTERS ///////////////
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the hometeam
	 */
	public TeamDao getHometeam() {
		return hometeam;
	}

	/**
	 * @param hometeam the hometeam to set
	 */
	public void setHometeam(TeamDao hometeam) {
		this.hometeam = hometeam;
	}

	/**
	 * @return the awayteam
	 */
	public TeamDao getAwayteam() {
		return awayteam;
	}

	/**
	 * @param awayteam the awayteam to set
	 */
	public void setAwayteam(TeamDao awayteam) {
		this.awayteam = awayteam;
	}

	/**
	 * @return the hometeamscore
	 */
	public int getHometeamscore() {
		return hometeamscore;
	}

	/**
	 * @param hometeamscore the hometeamscore to set
	 */
	public void setHometeamscore(int hometeamscore) {
		this.hometeamscore = hometeamscore;
	}

	/**
	 * @return the awayteamscore
	 */
	public int getAwayteamscore() {
		return awayteamscore;
	}

	/**
	 * @param awayteamscore the awayteamscore to set
	 */
	public void setAwayteamscore(int awayteamscore) {
		this.awayteamscore = awayteamscore;
	}

	/**
	 * @return the matchdate
	 */
	public Date getMatchdate() {
		return matchdate;
	}

	/**
	 * @param matchdate the matchdate to set
	 */
	public void setMatchdate(Date matchdate) {
		this.matchdate = matchdate;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the hasBet
	 */
	public boolean isHasBet() {
		return hasBet;
	}

	/**
	 * @param hasBet the hasBet to set
	 */
	public void setHasBet(boolean hasBet) {
		this.hasBet = hasBet;
	}

	/**
	 * @return the homeBet
	 */
	public int getHomeBet() {
		return homeBet;
	}

	/**
	 * @param homeBet the homeBet to set
	 */
	public void setHomeBet(int homeBet) {
		this.homeBet = homeBet;
	}

	/**
	 * @return the awayBet
	 */
	public int getAwayBet() {
		return awayBet;
	}

	/**
	 * @param awayBet the awayBet to set
	 */
	public void setAwayBet(int awayBet) {
		this.awayBet = awayBet;
	}

	/**
	 * @return the obtainedpoints
	 */
	public int getObtainedpoints() {
		return obtainedpoints;
	}

	/**
	 * @param obtainedpoints the obtainedpoints to set
	 */
	public void setObtainedpoints(int obtainedpoints) {
		this.obtainedpoints = obtainedpoints;
	}

	/**
	 * @return the bets
	 */
	@JsonIgnore
	public List<BetDao> getBets() {
		return bets;
	}

	public void setBets(List<BetDao> bets) {
		this.bets = bets;
	}

/////////////// TOSTRING ///////////////

	@Override
	public String toString() {
		return "MatchDto [id=" + id + ", hometeam=" + hometeam + ", awayteam=" + awayteam + ", hometeamscore="
				+ hometeamscore + ", awayteamscore=" + awayteamscore + ", matchdate=" + matchdate + ", status=" + status
				+ ", bets=" + bets + ", hasBet=" + hasBet + ", homeBet=" + homeBet + ", awayBet=" + awayBet
				+ ", obtainedpoints=" + obtainedpoints + "]";
	}

}
