package com.example.testtest.repositories;

import com.example.testtest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer ,Integer> {
}
