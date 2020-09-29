package com.kevhaes.model;

public class UserDto {
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String role;
	private Boolean isActive;
	private String imageurl;

	// constructors
	public UserDto(String username, String firstname, String lastname, String password, String role, Boolean isActive,
			String imageurl) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.imageurl = imageurl;
	}

	public UserDto() {
		super();
	}

	// getters setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

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

	public String getPassword() {
		return password;
	}

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

	// to string
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", role=" + role + ", isActive=" + isActive + ", imageurl=" + imageurl + "]";
	}

}
