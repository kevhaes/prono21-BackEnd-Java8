/**
 * @author KevHaes
 *
 */
package com.kevhaes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.model.CommentDao;

/**
 * @author KevHaes
 *
 */
public interface CommentRepository extends JpaRepository<CommentDao, Long> {
	List<CommentDao> findByPostId(Long postId);
	/////////////// ATRIBUTES ///////////////

	/////////////// CONSTRUCTORS ///////////////

	/////////////// GETTERS & SETTERS ///////////////

	/////////////// METHODS ///////////////

	/////////////// TOSTRING ///////////////

}
