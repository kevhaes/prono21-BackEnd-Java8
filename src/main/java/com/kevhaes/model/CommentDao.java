/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author KevHaes
 *
 */
@Entity
@Table(name = "comment")
public class CommentDao {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserDao author;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostDao post;

	@Column(name = "published_on")
	@CreationTimestamp
	private LocalDateTime publishedOn;

	/////////////// CONSTRUCTORS ///////////////

	public CommentDao(long id, String description, UserDao author, PostDao post, LocalDateTime publishedOn) {
		this.id = id;
		this.description = description;
		this.author = author;
		this.post = post;
		this.publishedOn = publishedOn;
	}

	public CommentDao() {
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
	 * @return the author
	 */
	public UserDao getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(UserDao author) {
		this.author = author;
	}

	/**
	 * @return the post
	 */
	@JsonIgnore
	public PostDao getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(PostDao post) {
		this.post = post;
	}

	/**
	 * @return the publishedOn
	 */
	public LocalDateTime getPublishedOn() {
		return publishedOn;
	}

	/**
	 * @param publishedOn the publishedOn to set
	 */
	public void setPublishedOn(LocalDateTime publishedOn) {
		this.publishedOn = publishedOn;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "CommentDao [id=" + id + ", description=" + description + ", author=" + author + ", post=" + post + "]";
	}

	/////////////// METHODS ///////////////

}
