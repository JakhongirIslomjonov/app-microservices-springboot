package com.example.customer.mappers;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.entity.Customer;
import org.mapstruct.*;

@Mapper( componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toEntity(CustomerDTO customerDTO);

    CustomerDTO toDto(Customer customer);


}