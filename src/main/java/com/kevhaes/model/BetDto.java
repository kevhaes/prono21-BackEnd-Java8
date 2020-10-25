/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

/**
 * @author KevHaes
 *
 */
public class BetDto {
	/////////////// ATRIBUTES ///////////////
	// private String id;
	private String user_id;
	private Long match_id;
	private int hometeambet;
	private int awayteambet;

	/////////////// CONSTRUCTORS ///////////////
	public BetDto(String user_id, Long match_id, int hometeambet, int awayteambet) {
		super();
		this.user_id = user_id;
		this.match_id = match_id;
		this.hometeambet = hometeambet;
		this.awayteambet = awayteambet;
	}

	public BetDto() {
		super();
	}

	/////////////// GETTERS & SETTERS ///////////////

	/**
	 * @return the user
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the match
	 */
	public Long getMatch_id() {
		return match_id;
	}

	/**
	 * @param match the match to set
	 */
	public void setMatch(Long match_id) {
		this.match_id = match_id;
	}

	/**
	 * @return the homeTeamBet
	 */
	public int getHomeTeamBet() {
		return hometeambet;
	}

	/**
	 * @param homeTeamBet the homeTeamBet to set
	 */
	public void setHomeTeamBet(int homeTeamBet) {
		this.hometeambet = homeTeamBet;
	}

	/**
	 * @return the awayTeamBet
	 */
	public int getAwayTeamBet() {
		return awayteambet;
	}

	/**
	 * @param awayTeamBet the awayTeamBet to set
	 */
	public void setAwayTeamBet(int awayTeamBet) {
		this.awayteambet = awayTeamBet;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "BetDto [user_id=" + user_id + ", match_id=" + match_id + ", hometeambet=" + hometeambet
				+ ", awayteambet=" + awayteambet + "]";
	}

	/////////////// METHODS ///////////////

}
