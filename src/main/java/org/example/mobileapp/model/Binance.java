package org.example.mobileapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "binance")
public class Binance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double pay;
    private String date;
    private String time;

    @ManyToOne
    private Accountant accountant;
}
