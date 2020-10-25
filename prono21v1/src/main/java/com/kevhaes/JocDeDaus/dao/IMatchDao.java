/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.Match;

/**
 * @author KevHaes
 *
 */
public interface IMatchDao extends JpaRepository<Match, Long> {

}
