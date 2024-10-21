package org.example.mobileapp.service;


import org.example.mobileapp.model.Salary;
import org.example.mobileapp.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public ResponseEntity<?> calculateSalary(Long employeeId, int week) {
        Salary salary = salaryRepository.findByEmployeeIdAndWeek(employeeId, String.valueOf(week));
        if (salary == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Salary data not found");
        }

        double totalSalary = salary.getBasic() + salary.getBonus(); // fix
        return ResponseEntity.ok("Total salary: " + totalSalary);
    }

    // Additional salary calculation methods
}
