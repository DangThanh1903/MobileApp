package org.example.mobileapp.controller;


import org.example.mobileapp.DTO.GameAccountRequest;
import org.example.mobileapp.model.GameAccount;
import org.example.mobileapp.service.GameAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gameaccounts")
public class GameAccountController {

    @Autowired
    private GameAccountService gameAccountService;

    @PostMapping("/add")
    public ResponseEntity<?> addGameAccount(@RequestBody GameAccountRequest request) {
        return gameAccountService.addGameAccount(request);
    }

    @GetMapping("/all")
    public List<GameAccount> getAllGameAccounts() {
        return gameAccountService.getAllGameAccounts();
    }

    // Additional APIs for game account management
}
