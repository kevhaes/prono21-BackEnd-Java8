/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

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
public class MatchDao {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "hometeam")
	private TeamDao hometeam;

	@ManyToOne
	@JoinColumn(name = "awayteam")
	private TeamDao awayteam;

	private int hometeamscore;
	private int awayteamscore;
	private Date matchdate;
	private int status;

	@OneToMany
	@JoinColumn(name = "id")
	List<BetDao> bets;

	/////////////// CONSTRUCTORS ///////////////
	public MatchDao(Long id, TeamDao hometeam, TeamDao awayteam, int hometeamscore, int awayteamscore, Date matchdate,
			int status, List<BetDao> bets) {
		super();
		this.id = id;
		this.hometeam = hometeam;
		this.awayteam = awayteam;
		this.hometeamscore = hometeamscore;
		this.awayteamscore = awayteamscore;
		this.matchdate = matchdate;
		this.status = status;
		this.bets = bets;
	}

	public MatchDao() {
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
	 * @return the hometeam_id
	 */
	// @JsonIgnore
	public TeamDao getHometeam() {
		return hometeam;
	}

	/**
	 * @param hometeam_id the hometeam_id to set
	 */
	public void setHometeam(TeamDao hometeam) {
		this.hometeam = hometeam;
	}

	/**
	 * @return the awayteam_id
	 */
	// @JsonIgnore
	public TeamDao getAwayteam() {
		return awayteam;
	}

	/**
	 * @param awayteam_id the awayteam_id to set
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
	 * @return the bets
	 */
	@JsonIgnore
	public List<BetDao> getBets() {
		return bets;
	}

	/**
	 * @param bets the bets to set
	 */

	public void setBets(List<BetDao> bets) {
		this.bets = bets;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "MatchDao [id=" + id + ", hometeam=" + hometeam + ", awayteam=" + awayteam + ", hometeamscore="
				+ hometeamscore + ", awayteamscore=" + awayteamscore + ", matchdate=" + matchdate + ", status=" + status
				+ ", bets= [jsonIgnored]" + "]";
	}

	/////////////// METHODS ///////////////

}
