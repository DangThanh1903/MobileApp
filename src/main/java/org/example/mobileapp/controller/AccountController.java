package org.example.mobileapp.controller;

import org.example.mobileapp.DTO.CreateAccountRequest;
import org.example.mobileapp.DTO.LoginRequest;
import org.example.mobileapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    // Additional APIs for account management
}


