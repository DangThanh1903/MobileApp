package org.example.mobileapp.repository;

import org.example.mobileapp.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Salary findByEmployeeIdAndWeek(Long employee_id, String week);
}
