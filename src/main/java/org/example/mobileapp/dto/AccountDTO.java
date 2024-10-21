package org.example.mobileapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private String username;
    private String password;
    private String employeeName;  // Employee info
    private int level;            // 0 = Admin, 1 = Staff
    private String imagePath;

    // Getters and Setters
}
