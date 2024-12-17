package com.example.sparta_todo_develop.repository;

import com.example.sparta_todo_develop.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
