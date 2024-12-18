package com.example.sparta_todo_develop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@Getter
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void updateTodo(String title, String content){
        this.title = title;
        this.content = content;
    }
}
