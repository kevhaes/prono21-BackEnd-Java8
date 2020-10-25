/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kevhaes.JocDeDaus.dto.enums.Gender;

/**
 * @author KevHaes
 *
 */
@Entity
@Table(name = "users")
public class User {

	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;

	private Gender gender;
	private int totalscore;
	private String description;
	private String profileimage;

	@OneToMany
	private List<Bet> bets;

	/////////////// CONSTRUCTORS ///////////////
	public User(Long id, String username, String firstname, String lastname, String password, Gender gender,
			int totalscore, String description, String profileimage, List<Bet> bets) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.gender = gender;
		this.totalscore = totalscore;
		this.description = description;
		this.profileimage = profileimage;
		this.bets = bets;
	}

	public User() {
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
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
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
	 * @return the profileimage
	 */
	public String getProfileimage() {
		return profileimage;
	}

	/**
	 * @param profileimage the profileimage to set
	 */
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
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
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", gender=" + gender + ", totalscore=" + totalscore + ", description="
				+ description + ", profileimage=" + profileimage + "]";
	}

	/////////////// METHODS ///////////////

}
