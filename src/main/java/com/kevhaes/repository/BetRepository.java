/**
 * @author KevHaes
 *
 */
package com.kevhaes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.model.BetDao;

/**
 * @author KevHaes
 *
 */
public interface BetRepository extends JpaRepository<BetDao, Long> {

}
