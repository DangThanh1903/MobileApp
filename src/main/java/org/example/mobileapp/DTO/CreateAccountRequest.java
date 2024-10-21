package org.example.mobileapp.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
    private String username;
    private String password;
    private String name;
    private int age;
    private String role; // admin, accountant, worker
}
