package org.example.mobileapp.service;


import org.example.mobileapp.model.Employee;
import org.example.mobileapp.model.TimeAttendant;
import org.example.mobileapp.repository.EmployeeRepository;
import org.example.mobileapp.repository.TimeAttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TimeAttendantService {

    @Autowired
    private TimeAttendantRepository timeAttendantRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<?> recordAttendance(Long employeeId) {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        if (employeeOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }

        Employee employee = employeeOpt.get();
        TimeAttendant timeAttendant = new TimeAttendant(employee, LocalDate.now(), LocalTime.now());
        timeAttendantRepository.save(timeAttendant);

        return ResponseEntity.ok("Attendance recorded for employee: " + employee.getName());
    }

    public List<TimeAttendant> getAttendanceRecords(Long employeeId) {
        return timeAttendantRepository.findByEmployeeId(employeeId);
    }
}
