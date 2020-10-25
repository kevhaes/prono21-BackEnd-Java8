/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author KevHaes
 *
 */
@Entity
public class Bet {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user_id;

	private int hometeambet;
	private int awayteambet;
	private int obtainedpoints;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private Match match;

	/////////////// CONSTRUCTORS ///////////////

	public Bet(Long id, User user_id, Match match, int homeTeamBet, int awayTeamBet, int obtainedPoints) {
		this.id = id;
		this.user_id = user_id;
		this.match = match;
		this.hometeambet = homeTeamBet;
		this.awayteambet = awayTeamBet;
		this.obtainedpoints = obtainedPoints;

	}

	public Bet() {
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
	 * @return the user
	 */
	public User getUser() {
		return user_id;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user_id) {
		this.user_id = user_id;
	}

	/**
	 * // * @return the match //
	 */
	// @JsonIgnore
	public Match getMatch() {
		return match;
	}

	/**
	 * @param match the match to set
	 */
	public void setMatch(Match match) {
		this.match = match;
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

	/**
	 * @return the obtainedPoints
	 */
	public int getObtainedPoints() {
		return obtainedpoints;
	}

	/**
	 * @param obtainedPoints the obtainedPoints to set
	 */
	public void setObtainedPoints(int obtainedPoints) {
		this.obtainedpoints = obtainedPoints;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "Bet [id=" + id + ", user_id=" + user_id + ", hometeambet=" + hometeambet + ", awayteambet="
				+ awayteambet + ", obtainedpoints=" + obtainedpoints + ", match=" + match + "]";
	}

	/////////////// METHODS ///////////////

}
