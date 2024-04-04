package com.example.testtest.service;

import com.example.testtest.entities.Customer;
import com.example.testtest.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
    public Page<Customer> getCustomers(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size));

    }
    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Customer Number " + id + " DOES NOT EXIST !!!")
        );
    }

    @Transactional
    public Customer createNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Transactional
    public void removeCustomer(Integer id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
    }
}
