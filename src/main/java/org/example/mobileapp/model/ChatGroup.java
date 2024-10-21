package org.example.mobileapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chat_group")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;
    private String lastMessage;

    @ManyToMany
    private List<Employee> members;
}