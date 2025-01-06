package com.example.sparta_todo_develop.repository;

import com.example.sparta_todo_develop.entity.User;
import com.example.sparta_todo_develop.exception.UserNotFoundException;
import com.example.sparta_todo_develop.exception.error.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_BY_ID));
    }

    default User findByEmailOrElseThrow(String email) {
        return findByEmail(email).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_BY_EMAIL));
    }

    Optional<User> findByEmail(String email);
}
