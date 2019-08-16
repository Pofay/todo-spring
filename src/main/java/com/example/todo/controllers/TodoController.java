package com.example.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.todo.entities.Todo;
import com.example.todo.repositories.TodoRepository;
import com.example.todo.responses.TodoJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Iterable<Todo> todos = todoRepo.findAll();
        Iterable<TodoJSON> payload = transformToJson(todos);

        return ResponseEntity.ok().body(payload);
    }

    @GetMapping(value = "/api/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSpecificTodo(@PathVariable("id") long id) {
        Todo todo = todoRepo.findById(Long.valueOf(id)).get();
        TodoJSON payload = new TodoJSON(todo.getId(), todo.getName(), todo.getStatus());

        return ResponseEntity.ok().body(payload);
    }

    private Iterable<TodoJSON> transformToJson(Iterable<Todo> todos) {
        List<TodoJSON> payload = new ArrayList<>();
        for (Todo t : todos) {
            TodoJSON json = new TodoJSON(t.getId(), t.getName(), t.getStatus());
            payload.add(json);
        }

        return payload;
    }
}
