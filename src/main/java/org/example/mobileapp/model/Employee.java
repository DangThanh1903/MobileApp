package org.example.mobileapp.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int level;  // 0 = Admin, 1 = Staff
    private LocalDate startDate;
    private String imagePath;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;

}
