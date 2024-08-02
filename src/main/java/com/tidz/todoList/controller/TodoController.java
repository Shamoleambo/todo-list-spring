package com.tidz.todoList.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidz.todoList.entity.Todo;
import com.tidz.todoList.service.TodoService;

@RestController
@RequestMapping("/api/todos")
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

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
		Todo todo = this.todoService.getTodoById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
		todo.setTitle(todoDetails.getTitle());
		todo.setCompleted(todoDetails.isCompleted());
		return todoService.saveTodo(todo);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Long id) {
		this.todoService.deleteTodoById(id);
	}
}
