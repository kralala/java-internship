package com.example.liquibasedemo.service;

import com.example.liquibasedemo.dto.CustomerDTO;
import com.example.liquibasedemo.entity.Customer;
import com.example.liquibasedemo.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private  CustomerRepository customerRepository;

    public List<CustomerDTO> enumerate() {
        List<Customer> customerList =  customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDTOList.add(new CustomerDTO(customer));
        }
        return customerDTOList;
    }

    public Customer save(Customer customer) {
        customer.setId(UUID.randomUUID());
        return customerRepository.save(customer);
    }

    public Customer get(UUID id) {
        return customerRepository.findById(id).get();
    }

    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }


    public Customer create(Customer customer) {
        customer.setId(UUID.randomUUID());
        return customerRepository.save(customer);
    }

}