package org.example.mobileapp.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameAccountRequest {
    private String username;
    private String password;
    private String status;
    private String server;
    private int corn;
    private int wood;
    private int stone;
    private int gold;
    private double price;

}
