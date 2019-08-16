package com.example.todo.requests;

public class CreateTodoRequest {

    private String name;
    private String status;

    public CreateTodoRequest() {
    }

    public CreateTodoRequest(String name, String status) {
        this.setName(name);
        this.setStatus(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
