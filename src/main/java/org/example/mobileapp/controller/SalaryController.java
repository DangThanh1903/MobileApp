package org.example.mobileapp.controller;


import org.example.mobileapp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/calculate/{employeeId}/{week}")
    public ResponseEntity<?> calculateSalary(@PathVariable Long employeeId, @PathVariable int week) {
        return salaryService.calculateSalary(employeeId, week);
    }

    // Additional endpoints for salary management
}
