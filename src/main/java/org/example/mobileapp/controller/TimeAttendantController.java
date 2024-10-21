package org.example.mobileapp.controller;


import org.example.mobileapp.model.TimeAttendant;
import org.example.mobileapp.service.TimeAttendantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class TimeAttendantController {

    @Autowired
    private TimeAttendantService timeAttendantService;

    // Record attendance for an employee
    @PostMapping("/record/{employeeId}")
    public ResponseEntity<?> recordAttendance(@PathVariable Long employeeId) {
        return timeAttendantService.recordAttendance(employeeId);
    }

    // Get attendance records for a specific employee
    @GetMapping("/records/{employeeId}")
    public List<TimeAttendant> getAttendanceRecords(@PathVariable Long employeeId) {
        return timeAttendantService.getAttendanceRecords(employeeId);
    }
}

