package org.example.mobileapp.service;

import org.example.mobileapp.dto.AccountDTO;
import org.example.mobileapp.dto.LoginDTO;
import org.example.mobileapp.model.Account;
import org.example.mobileapp.model.Employee;
import org.example.mobileapp.repository.AccountRepository;
import org.example.mobileapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Register new account
    public void register(AccountDTO accountDTO) {
        Optional<Account> existingAccount = accountRepository.findByUsername(accountDTO.getUsername());
        if (existingAccount.isPresent()) {
            throw new IllegalStateException("Username already taken");
        }

        // Create and save a new employee for the account
        Employee employee = new Employee();
        employee.setName(accountDTO.getEmployeeName());
        employee.setLevel(accountDTO.getLevel());  // 0 = Admin, 1 = Staff
        employee.setStartDate(LocalDate.now());
        employee.setImagePath(accountDTO.getImagePath());

        Employee savedEmployee = employeeRepository.save(employee);

        // Create and save the account
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setPassword(accountDTO.getPassword());  // In production, you should hash passwords
        account.setEmployee(savedEmployee);

        accountRepository.save(account);
    }

    // Login logic
    public boolean login(LoginDTO loginDTO) {
        Optional<Account> accountOptional = accountRepository.findByUsername(loginDTO.getUsername());

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();

            // Simple password check (should hash passwords in production)
            return account.getPassword().equals(loginDTO.getPassword());  // Login success
        }
        return false;  // Login failed
    }

}
