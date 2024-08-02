package com.tidz.todoList.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.todoList.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String username);
}
