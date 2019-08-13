package com.example.todo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String status;

    public Todo() {
    }

    public Todo(String name) {
        this.name = name;
        this.status = "INCOMPLETE";
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
