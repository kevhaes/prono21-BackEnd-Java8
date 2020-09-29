/**
 * @author KevHaes
 *
 */
package com.kevhaes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.model.MatchDao;

/**
 * @author KevHaes
 *
 */
public interface MatchRepository extends JpaRepository<MatchDao, Long> {

}
