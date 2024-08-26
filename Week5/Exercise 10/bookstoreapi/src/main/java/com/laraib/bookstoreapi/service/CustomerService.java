package com.mansoor.bookstoreapi.service;

import com.mansoor.bookstoreapi.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    boolean deleteCustomer(Long id);
}

