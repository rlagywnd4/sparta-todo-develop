package com.example.sparta_todo_develop.service;

import com.example.sparta_todo_develop.dto.todo.TodoRequestDto;
import com.example.sparta_todo_develop.dto.todo.TodoResponseDto;
import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<TodoResponseDto> findAll() {
        List<TodoResponseDto> responseDtos = todoRepository.findAll().stream().map(TodoResponseDto::new).collect(Collectors.toList());

        return responseDtos;
    }

    public TodoResponseDto findById(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        return new TodoResponseDto(findTodo);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, String title, String content) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        findTodo.updateTodo(title, content);

        return new TodoResponseDto(findTodo);
    }

    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        todoRepository.delete(findTodo);
    }
}
