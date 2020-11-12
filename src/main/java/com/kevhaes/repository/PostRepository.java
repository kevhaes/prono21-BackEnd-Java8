/**
 * @author KevHaes
 *
 */
package com.kevhaes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.model.PostDao;

/**
 * @author KevHaes
 *
 */
public interface PostRepository extends JpaRepository<PostDao, Long> {

}
