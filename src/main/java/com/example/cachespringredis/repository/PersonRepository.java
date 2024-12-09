package com.example.cachespringredis.repository;

import com.example.cachespringredis.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByPhoneNumber(String phoneNumber);
}