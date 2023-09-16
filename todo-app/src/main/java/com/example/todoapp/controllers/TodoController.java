package com.example.todoapp.controllers;

import com.example.todoapp.entities.Todo;
import com.example.todoapp.entities.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Todo> getTodo(@PathVariable("id") Long id){
        var todo = todoRepository.findById(id);
        return todo;
    }

    @PostMapping
    public Todo newTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Optional<Todo> updateTodo(@RequestBody Todo updatedTodo, @PathVariable("id") Long id){
        return this.todoRepository.findById(id)
                .map(oldTodo -> this.todoRepository.save(updatedTodo));
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") Long id){
        this.todoRepository.deleteById(id);
    }
}
