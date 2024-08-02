package com.tidz.todoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> getAllTodos() {
		return this.todoService.getAllTodos();
	}

	@GetMapping("/{id}")
	public Optional<Todo> getTodoById(@PathVariable Long id) {
		return this.todoService.getTodoById(id);
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return this.todoService.saveTodo(todo);
	}
}
