package com.tidz.todoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getAllTodos() {
		return this.todoRepository.findAll();
	}

	public Optional<Todo> getTodoById(Long id) {
		return this.todoRepository.findById(id);
	}

	public Todo saveTodo(Todo todo) {
		return this.todoRepository.save(todo);
	}
	
	public void deleteTodoById(Long id) {
		this.todoRepository.deleteById(id);
	}
}
