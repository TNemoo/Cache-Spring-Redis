package com.example.cachespringjedisredis.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String firstname;
    @Column(updatable = false)
    private String surname;
    @Column(name = "phone_number", unique = true, updatable = false)
    private String phoneNumber;
    @ElementCollection
    private List<BankAccount> bankAccount = new ArrayList<>();

    public Person() {
    }
}
