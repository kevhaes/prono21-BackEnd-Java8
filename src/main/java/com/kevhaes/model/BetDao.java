/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author KevHaes
 *
 */
@Entity
@Table(name = "`bet`")
public class BetDao {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserDao user;

	@Column
	private int hometeambet;
	@Column
	private int awayteambet;
	@Column
	private int obtainedpoints;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private MatchDao match;

	/////////////// CONSTRUCTORS ///////////////
	public BetDao(Long id, UserDao user, MatchDao match, int homeTeamBet, int awayTeamBet, int obtainedPoints) {
		this.id = id;
		this.user = user;
		this.match = match;
		this.hometeambet = homeTeamBet;
		this.awayteambet = awayTeamBet;
		this.obtainedpoints = obtainedPoints;

	}

	public BetDao() {
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
	public UserDao getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDao user) {
		this.user = user;
	}

	/**
	 * @return the hometeambet
	 */
	public int getHometeambet() {
		return hometeambet;
	}

	/**
	 * @param hometeambet the hometeambet to set
	 */
	public void setHometeambet(int hometeambet) {
		this.hometeambet = hometeambet;
	}

	/**
	 * @return the awayteambet
	 */
	public int getAwayteambet() {
		return awayteambet;
	}

	/**
	 * @param awayteambet the awayteambet to set
	 */
	public void setAwayteambet(int awayteambet) {
		this.awayteambet = awayteambet;
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
	 * @return the match
	 */
	public MatchDao getMatch() {
		return match;
	}

	/**
	 * @param match the match to set
	 */
	public void setMatch(MatchDao match) {
		this.match = match;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "BetDao [id=" + id + ", user=" + user + ", hometeambet=" + hometeambet + ", awayteambet=" + awayteambet
				+ ", obtainedpoints=" + obtainedpoints + ", match=" + match + "]";
	}

	/////////////// METHODS ///////////////

}
