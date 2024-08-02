package com.tidz.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.todoList.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
