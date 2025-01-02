package com.example.sparta_todo_develop.dto.todo;

import com.example.sparta_todo_develop.entity.Todo;
import com.example.sparta_todo_develop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private final Long id;
    private final User user;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static TodoResponseDto from(Todo todo){
        return new TodoResponseDto(
                todo.getId(),
                todo.getUser(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }
}
