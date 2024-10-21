package org.example.mobileapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker extends Employee {
    private int numOfGameAccounts;
}