/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.User;

/**
 * @author KevHaes
 *
 */
public interface IUserDao extends JpaRepository<User, Long> {

}
