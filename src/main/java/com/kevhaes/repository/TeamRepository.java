/**
 * @author KevHaes
 *
 */
package com.kevhaes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.model.TeamDao;

/**
 * @author KevHaes
 *
 */
public interface TeamRepository extends JpaRepository<TeamDao, Long> {
	TeamDao findByName(String name);
}
