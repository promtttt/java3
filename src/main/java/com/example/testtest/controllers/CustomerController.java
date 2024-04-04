package com.example.testtest.controllers;

import com.example.testtest.entities.Customer;
import com.example.testtest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize){
        Page<Customer> customerPage = service.getCustomers(page, pageSize);
        return   ResponseEntity.ok(customerPage);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return service.getCustomer(id);
    }

    @PostMapping("")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        return service.createNewCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void removeCustomer(@PathVariable Integer id) {
        service.removeCustomer(id);
    }
}
