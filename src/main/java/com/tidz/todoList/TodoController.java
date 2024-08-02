package com.tidz.todoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	public List<Todo> getAllTodos() {
		return this.todoService.getAllTodos();
	}
}
