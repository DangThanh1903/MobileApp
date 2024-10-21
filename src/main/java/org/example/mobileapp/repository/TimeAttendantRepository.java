package org.example.mobileapp.repository;

import org.example.mobileapp.model.TimeAttendant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeAttendantRepository extends JpaRepository<TimeAttendant, Long> {
    List<TimeAttendant> findByEmployeeId(Long employeeId);
}
