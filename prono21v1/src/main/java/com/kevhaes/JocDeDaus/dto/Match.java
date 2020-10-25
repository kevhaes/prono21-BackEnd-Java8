/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author KevHaes
 *
 */
@Entity
@Table(name = "`match`")
public class Match {

	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "hometeam_id")
	private Team hometeam_id;

	@ManyToOne
	@JoinColumn(name = "awayteam_id")
	private Team awayteam_id;

	private int hometeamscore;
	private int awayteamscore;
	private Date matchdate;
	private int status;

	@OneToMany
	@JoinColumn(name = "id")
	List<Bet> bets;

	public Match(Long id, Team hometeam_id, Team awayteam_id, int hometeamscore, int awayteamscore, Date matchdate,
			int status) {
		this.id = id;
		this.hometeam_id = hometeam_id;
		this.awayteam_id = awayteam_id;
		this.hometeamscore = hometeamscore;
		this.awayteamscore = awayteamscore;
		this.matchdate = matchdate;
		this.status = status;
	}

	public Match() {
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
	 * @return the hometeam_id
	 */
	public Team getHometeam_id() {
		return hometeam_id;
	}

	/**
	 * @param hometeam_id the hometeam_id to set
	 */
	public void setHometeam_id(Team hometeam_id) {
		this.hometeam_id = hometeam_id;
	}

	/**
	 * @return the awayteam_id
	 */
	public Team getAwayteam_id() {
		return awayteam_id;
	}

	/**
	 * @param awayteam_id the awayteam_id to set
	 */
	public void setAwayteam_id(Team awayteam_id) {
		this.awayteam_id = awayteam_id;
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
	 * @return the bets
	 */
	@JsonIgnore
	public List<Bet> getBets() {
		return bets;
	}

	/**
	 * @param bets the bets to set
	 */
	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "Match [id=" + id + ", hometeam_id=" + hometeam_id + ", awayteam_id=" + awayteam_id + ", hometeamscore="
				+ hometeamscore + ", awayteamscore=" + awayteamscore + ", matchdate=" + matchdate + ", status=" + status
				+ ", bets=" + bets + "]";
	}

}
