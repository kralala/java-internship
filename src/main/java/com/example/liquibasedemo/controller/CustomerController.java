package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.dto.CustomerDTO;
import com.example.liquibasedemo.entity.Customer;
import com.example.liquibasedemo.persistence.CustomerRepository;
import com.example.liquibasedemo.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/api/v1/crud/customer")
@RequiredArgsConstructor
@Api(value = "Customer CRUD operations", description = "Customer CRUD operations")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @ApiOperation(value = "Enumerates all Customer entities")
    @ResponseStatus(ACCEPTED)
    @GetMapping
    public List<CustomerDTO> enumerate() {
        return customerService.enumerate();
    }

    @ApiOperation(value = "Stores given Customer entity")
    @ResponseStatus(ACCEPTED)
    @PutMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @ApiOperation(value = "Retrieves Customer entity by its ID")
    @ResponseStatus(ACCEPTED)
    @GetMapping("/{id}")
    public Customer get(@PathVariable("id")UUID id) {
        return customerService.get(id);
    }

    @ApiOperation(value = "Deletes Customer entity by its ID")
    @ResponseStatus(ACCEPTED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        customerService.delete(id);
    }

    @ApiOperation(value = "Creates a new Customer entity")
    @ResponseStatus(ACCEPTED)
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }


}
