package com.kevhaes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

//	@Column
//	private int totalscore;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "user_userstats", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "userstats_id", referencedColumnName = "id") })
	private UserStats userStats;

	@OneToMany
	@JoinColumn(name = "id")
	private List<PostDao> posts;

	@OneToMany
	@JoinColumn(name = "id")
	private List<CommentDao> comments;

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

	/**
	 * @return the userStats
	 */
	public UserStats getUserStats() {
		return userStats;
	}

	/**
	 * @param userStats the userStats to set
	 */
	public void setUserStats(UserStats userStats) {
		this.userStats = userStats;
	}

	/**
	 * @return the posts
	 */
	@JsonIgnore
	public List<PostDao> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<PostDao> posts) {
		this.posts = posts;
	}

	/**
	 * @return the comments
	 */
	@JsonIgnore
	public List<CommentDao> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentDao> comments) {
		this.comments = comments;
	}

	// to string
	@Override
	public String toString() {
		return "UserDao [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", role=" + role + ", isActive=" + isActive + ", description="
				+ description + ", imageurl=" + imageurl + ", bets= [ignored]" + ", userStats=" + userStats + ", posts="
				+ "[ignored]" + "]";
	}

}
