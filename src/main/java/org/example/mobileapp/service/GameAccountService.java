package org.example.mobileapp.service;


import org.example.mobileapp.DTO.GameAccountRequest;
import org.example.mobileapp.model.GameAccount;
import org.example.mobileapp.repository.GameAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameAccountService {

    @Autowired
    private GameAccountRepository gameAccountRepository;

    public ResponseEntity<?> addGameAccount(GameAccountRequest request) {
        GameAccount gameAccount = new GameAccount();
        gameAccount.setUsername(request.getUsername());
        gameAccount.setPassword(request.getPassword());
        gameAccount.setStatus(request.getStatus());
        gameAccount.setCorn(request.getCorn());
        gameAccount.setWood(request.getWood());
        gameAccount.setStone(request.getStone());
        gameAccount.setGold(request.getGold());
        gameAccount.setPrice(request.getPrice());
        gameAccount.setServer(request.getServer());
        gameAccountRepository.save(gameAccount);

        return ResponseEntity.ok("Game account created");
    }

    public List<GameAccount> getAllGameAccounts() {
        return gameAccountRepository.findAll();
    }

    // Additional logic for game account management
}
