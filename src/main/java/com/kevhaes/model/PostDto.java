/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import java.util.List;

/**
 * @author KevHaes
 *
 */
public class PostDto {
	/////////////// ATRIBUTES ///////////////
	private Long id;
	private String title;
	private String description;
	private String author_username;
	private List<CommentDao> comments;

	/////////////// CONSTRUCTORS ///////////////
	public PostDto(Long id, String title, String description, String author_username, List<CommentDao> comments) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author_username = author_username;
		this.comments = comments;
	}

	public PostDto() {
		super();
	}

	/////////////// CONSTRUCTORS ///////////////

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the author_id
	 */
	public String getAuthor_username() {
		return author_username;
	}

	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_username(String author_username) {
		this.author_username = author_username;
	}

	/**
	 * @return the comments
	 */
	public List<CommentDao> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentDao> comments) {
		this.comments = comments;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", author_username="
				+ author_username + "]";
	}

}
