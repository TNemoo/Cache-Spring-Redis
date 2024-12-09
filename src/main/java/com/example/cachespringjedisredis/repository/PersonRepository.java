package com.example.cachespringjedisredis.repository;

import com.example.cachespringjedisredis.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByPhoneNumber(String phoneNumber);
}