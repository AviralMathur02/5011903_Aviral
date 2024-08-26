package com.mansoor.bookstoreapi.mapper;

//package com.mansoor.bookstoreapi.service.impl;

import com.mansoor.bookstoreapi.dto.CustomerDTO;
import com.mansoor.bookstoreapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    void updateCustomerFromDto(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
