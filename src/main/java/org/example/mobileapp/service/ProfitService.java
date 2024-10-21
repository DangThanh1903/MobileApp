package org.example.mobileapp.service;


import org.example.mobileapp.model.Profit;
import org.example.mobileapp.repository.ProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfitService {

    @Autowired
    private ProfitRepository profitRepository;

    public ResponseEntity<?> calculateProfit(Long customerId) {
        List<Profit> profits = profitRepository.findByCustomerId(customerId);
        double totalProfit = profits.stream()
                .mapToDouble(p -> p.getReceiveMoney() - p.getRealMoney())
                .sum();
        return ResponseEntity.ok("Total profit: " + totalProfit);
    }

    // Additional logic for financial synthesis
}
