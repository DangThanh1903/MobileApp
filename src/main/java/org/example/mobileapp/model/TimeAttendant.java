package org.example.mobileapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "time_attendant")
public class TimeAttendant
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private LocalDate date;
    private LocalTime time;

    public TimeAttendant(Employee employee, LocalDate date, LocalTime time) {
        this.employee = employee;
        this.date = date;
        this.time = time;
    }

    public TimeAttendant() {

    }
}
