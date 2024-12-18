package com.example.sparta_todo_develop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void updateUser(String name, String email){
        this.name = name;
        this.email = email;
    }
}
