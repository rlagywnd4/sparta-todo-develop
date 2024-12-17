package com.example.sparta_todo_develop.service;

import com.example.sparta_todo_develop.dto.TodoRequestDto;
import com.example.sparta_todo_develop.dto.TodoResponseDto;
import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
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

    public List<TodoResponseDto> findAll() {
        List<TodoResponseDto> responseDtos = todoRepository.findAll().stream().map(TodoResponseDto::new).collect(Collectors.toList());

        return responseDtos;
    }

    public TodoResponseDto findById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if(optionalTodo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return new TodoResponseDto(optionalTodo.get());
    }
}
