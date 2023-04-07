package com.microservice.tuto.app.user.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.tuto.app.user.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);

	public Optional<User> findByUserNameOrEmail(String userNameOrEmail);

	public Optional<User> findByUserName(String userName);

	public Boolean existsByUserName(String userName);

	public Boolean existsByEmail(String email);
}
