package com.example.sparta_todo_develop.service;

import com.example.sparta_todo_develop.dto.TodoRequestDto;
import com.example.sparta_todo_develop.dto.TodoResponseDto;
import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto.getUserName(), requestDto.getTitle(), requestDto.getContent());

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo);
    }

    public List<TodoResponseDto> getTodos() {
        List<TodoResponseDto> responseDtos = todoRepository.findAll().stream().map(TodoResponseDto::new).collect(Collectors.toList());

        return responseDtos;
    }
}
