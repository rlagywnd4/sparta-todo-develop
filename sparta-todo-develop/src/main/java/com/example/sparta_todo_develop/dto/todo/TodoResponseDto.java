package com.example.sparta_todo_develop.dto.todo;

import com.example.sparta_todo_develop.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private final Long id;
    private final String userName;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    //TODO: 이런 방식도 괜찮나?
    //      new TodoResponseDto(todo.get~,...)가 너무 길어질 수 있다고 생각함
    //      아마 안될듯, 하나의 메소드,하나의 역할 규칙에 부합한가?
    public TodoResponseDto(Todo todo){
        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
