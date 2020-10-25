/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userstats")
public class UserStats {

	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int place;
	private int points;

	@OneToOne(mappedBy = "userStats")
	private UserDao user;

	/////////////// CONSTRUCTORS ///////////////

	public UserStats(long id, int place, int points, UserDao user) {
		super();
		this.id = id;
		this.place = place;
		this.points = points;
		this.user = user;
	}

	public UserStats() {
		super();
	}

	/////////////// GETTERS & SETTERS ///////////////
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the user
	 */
	@JsonIgnore
	public UserDao getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDao user) {
		this.user = user;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "UserStats [id=" + id + ", place=" + place + ", points=" + points + ", user= temp off" + "]";
	}

	/////////////// METHODS ///////////////
	public int compareTo(UserStats other) {
		if (points == other.points)
			return 0;
		else if (points < other.points)
			return -1;
		else
			return 1;
	}
}
