package com.kevhaes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String username;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	@JsonIgnore
	private String password;

	@Column
	private String role;

	@Column
	private Boolean isActive;

	@Column
	private int totalscore;

	@Column
	private String description;

	@Column
	private String imageurl;

	// set default role to user
	@PrePersist
	public void prePersist() {
		if (role == null) {
			role = "user";
		}
		if (imageurl == null) {
			imageurl = "https://www.uic.mx/posgrados/files/2018/05/default-user-300x300.png";
		}
	}

	@OneToMany
	@JoinColumn(name = "id")
	private List<BetDao> bets;

	// getters setter

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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the totalscore
	 */
	public int getTotalscore() {
		return totalscore;
	}

	/**
	 * @param totalscore the totalscore to set
	 */
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the imageurl
	 */
	public String getImageurl() {
		return imageurl;
	}

	/**
	 * @param imageurl the imageurl to set
	 */
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
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

	// to string
	@Override
	public String toString() {
		return "UserDao [id=" + id + ", username=" + username + ", firstname=" + firstname + ", Lastname=" + lastname
				+ ", password=" + password + ", role=" + role + ", isActive=" + isActive + ", totalscore=" + totalscore
				+ ", description=" + description + ", imageurl=" + imageurl + ", bets=[jsonIgnored]" + "]";
	}

}
