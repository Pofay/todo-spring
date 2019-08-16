package com.example.todo.controllers;

import com.example.todo.entities.Todo;
import com.example.todo.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private TodoRepository todoRepo;

    @Autowired
    public TodoController(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    @GetMapping(value = "/api/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllTodos() {
        Iterable<Todo> todo = todoRepo.findAll();
        return ResponseEntity.ok().body(todo);
    }
}
