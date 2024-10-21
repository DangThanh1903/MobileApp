package org.example.mobileapp.controller;


import org.example.mobileapp.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profits")
public class ProfitController {

    @Autowired
    private ProfitService profitService;

    @GetMapping("/calculate/{customerId}")
    public ResponseEntity<?> calculateProfit(@PathVariable Long customerId) {
        return profitService.calculateProfit(customerId);
    }

    // Additional endpoints for financial management
}
