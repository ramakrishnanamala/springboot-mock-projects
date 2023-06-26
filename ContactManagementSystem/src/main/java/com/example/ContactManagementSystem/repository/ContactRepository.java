package com.example.ContactManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ContactManagementSystem.entity.Person;

@Repository
public interface ContactRepository extends JpaRepository<Person, Integer> {

}
