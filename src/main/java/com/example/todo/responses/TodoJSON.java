package com.example.todo.responses;

public class TodoJSON {

    private Long id;
    private String name;
    private String status;

    public TodoJSON() {
    }

    public TodoJSON(Long id, String name, String status) {
        this.setId(id);
        this.setName(name);
        this.setStatus(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
