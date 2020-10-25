package com.kevhaes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.model.UserDao;

public interface UserRepository extends JpaRepository<UserDao, Long> {
	UserDao findByUsername(String username);

	// List<UserDao> findAllByOrderByTotalscoreDesc();
}