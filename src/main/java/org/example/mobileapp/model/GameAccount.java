package org.example.mobileapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "game_account")
public class GameAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String status;
    private String server;
    private int corn;
    private int wood;
    private int stone;
    private int gold;
    private double price;
    private String name;
    private double tax;
}

