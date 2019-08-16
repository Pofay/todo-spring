package com.example.todo;

import com.example.todo.entities.Todo;
import com.example.todo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TodoRepository todoRepo) {
        return (args) -> {
            todoRepo.deleteAll();

            createDummyTodos(todoRepo);
        };
    }

    public void createDummyTodos(TodoRepository todoRepo) {
        for (int i = 0; i < 5; i++) {
            Todo t = new Todo("Todo #" + i);
            todoRepo.save(t);
        }
    }
}
