package org.example.mobileapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String date;
    private String picture;

    @ManyToOne
    private ChatGroup chatGroup;
}