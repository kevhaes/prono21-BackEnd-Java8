/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.Bet;

/**
 * @author KevHaes
 *
 */
public interface IBetDao extends JpaRepository<Bet, Long> {

}
