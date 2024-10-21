package org.example.mobileapp.service;


import org.example.mobileapp.DTO.CreateAccountRequest;
import org.example.mobileapp.DTO.LoginRequest;
import org.example.mobileapp.model.*;
import org.example.mobileapp.repository.AccountRepository;
import org.example.mobileapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<Account> account = accountRepository.findByUsername(loginRequest.getUsername());
        if (account.isPresent() && account.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login successful for " + account.get().getUsername());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    public ResponseEntity<?> createAccount(CreateAccountRequest request) {
        if (accountRepository.findByUsername(request.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account already exists");
        }

        Account account = new Account();
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        accountRepository.save(account);

        // Create an associated Employee record based on the account role
        Employee employee;
        switch (request.getRole()) {
            case "admin":
                employee = new Admin();
                break;
            case "accountant":
                employee = new Accountant();
                break;
            case "worker":
                employee = new Worker();
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role");
        }
        employee.setAccount(account);
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employeeRepository.save(employee);

        return ResponseEntity.ok("Account created for " + request.getRole());
    }

    // Additional methods for account management
}


