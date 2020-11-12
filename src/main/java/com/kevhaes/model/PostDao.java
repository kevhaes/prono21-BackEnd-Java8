/**
 * @author KevHaes
 *
 */
package com.kevhaes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 * @author KevHaes
 *
 */
@Entity
@Table(name = "`post`")
public class PostDao {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserDao author;

	@Column(name = "published_on")
	@CreationTimestamp
	private LocalDateTime publishedOn;

	@OneToMany
	@JoinColumn(name = "id")
	private List<CommentDao> comments;

	/////////////// CONSTRUCTORS ///////////////

//	public PostDao(Long id, String title, String description, UserDao author, LocalDateTime publishedOn,
//			List<CommentDao> comments) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.author = author;
//		this.publishedOn = publishedOn;
//		this.comments = comments;
//	}

	public PostDao() {
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

	/**
	 * @return the comments
	 */
	// @JsonIgnore
	public List<CommentDao> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentDao> comments) {
		this.comments = comments;
	}

	/////////////// METHODS ///////////////
	public void addComment(CommentDao comment) {
		comments.add(comment);
		// comment.setPost(this);
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "PostDao [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", publishedOn=" + publishedOn + ", comments= IGNORED" + "]";
	}

}
