package org.example.mobileapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "seller")
public class Seller extends Employee {
    @OneToMany(mappedBy = "seller")
    private List<Customer> customers;
}