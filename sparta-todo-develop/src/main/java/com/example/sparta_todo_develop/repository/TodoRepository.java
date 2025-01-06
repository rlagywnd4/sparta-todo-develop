package com.example.sparta_todo_develop.repository;

import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.exception.TodoNotFoundException;
import com.example.sparta_todo_develop.exception.error.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new TodoNotFoundException(ErrorCode.TODO_NOT_FOUND_BY_ID));
    }
}
