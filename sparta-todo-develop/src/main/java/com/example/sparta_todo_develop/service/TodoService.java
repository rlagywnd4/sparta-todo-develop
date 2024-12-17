package com.example.sparta_todo_develop.service;

import com.example.sparta_todo_develop.dto.TodoRequestDto;
import com.example.sparta_todo_develop.dto.TodoResponseDto;
import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto.getUserName(), requestDto.getTitle(), requestDto.getContent());

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo);
    }
}
