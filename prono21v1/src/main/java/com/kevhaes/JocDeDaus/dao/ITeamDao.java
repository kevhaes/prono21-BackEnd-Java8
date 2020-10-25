/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.Team;

/**
 * @author KevHaes
 *
 */
public interface ITeamDao extends JpaRepository<Team, Long> {

}
