package com.example.sparta_todo_develop.service;

import com.example.sparta_todo_develop.dto.todo.TodoRequestDto;
import com.example.sparta_todo_develop.dto.todo.TodoResponseDto;
import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.entity.User;
import com.example.sparta_todo_develop.repository.TodoRepository;
import com.example.sparta_todo_develop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoResponseDto saveTodo(TodoRequestDto requestDto) {
        User findUser = userRepository.findByIdOrElseThrow(requestDto.getUserId());

        Todo todo = new Todo(findUser, requestDto.getTitle(), requestDto.getContent());
        Todo savedTodo = todoRepository.save(todo);

        return TodoResponseDto.from(savedTodo);
    }

    public List<TodoResponseDto> findAll() {
        List<TodoResponseDto> responseDtos = todoRepository.findAll().stream().map(TodoResponseDto::from).collect(Collectors.toList());

        return responseDtos;
    }

    public TodoResponseDto findById(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        return TodoResponseDto.from(findTodo);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, String title, String content) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        findTodo.updateTodo(title, content);

        return TodoResponseDto.from(findTodo);
    }

    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        todoRepository.delete(findTodo);
    }
}
