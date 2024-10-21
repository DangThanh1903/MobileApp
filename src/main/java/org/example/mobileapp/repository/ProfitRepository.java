package org.example.mobileapp.repository;

import org.example.mobileapp.model.Profit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfitRepository extends JpaRepository<Profit, Long> {
    List<Profit> findByCustomerId(Long customerId);
}
