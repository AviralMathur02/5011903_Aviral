package com.laraib.bookstoreapi.mapper;

//package com.lara.bookstoreapi.service.impl;

import com.laraib.bookstoreapi.dto.CustomerDTO;
import com.laraib.bookstoreapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    void updateCustomerFromDto(CustomerDTO customerDTO, @MappingTarget Customer customer);
}

