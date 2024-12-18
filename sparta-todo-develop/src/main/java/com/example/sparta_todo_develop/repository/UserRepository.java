package com.example.sparta_todo_develop.repository;

import com.example.sparta_todo_develop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
