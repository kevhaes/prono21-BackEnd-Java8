/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author KevHaes
 *
 */
@Entity
@Table(name = "`team`")
public class TeamDao {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String flagimage;
	private String description;
	private int status;

	@OneToMany
	@JoinColumn(name = "id")
	List<MatchDao> matches;

	/////////////// CONSTRUCTORS ///////////////
	public TeamDao(Long id, String name, String flagImage, String description, int status) {
		super();
		this.id = id;
		this.name = name;
		this.flagimage = flagImage;
		this.description = description;
		this.status = status;
	}

	public TeamDao() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the flagimage
	 */
	public String getFlagimage() {
		return flagimage;
	}

	/**
	 * @param flagimage the flagimage to set
	 */
	public void setFlagimage(String flagimage) {
		this.flagimage = flagimage;
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
	 * @return the matches
	 */
	@JsonIgnore
	public List<MatchDao> getMatches() {
		return matches;
	}

	/**
	 * @param matches the matches to set
	 */
	public void setMatches(List<MatchDao> matches) {
		this.matches = matches;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "TeamDao [id=" + id + ", name=" + name + ", flagimage=" + flagimage + ", description=" + description
				+ ", status=" + status + ", matches=[jsonIgnored] " + "]";
	}

	/////////////// METHODS ///////////////

}
