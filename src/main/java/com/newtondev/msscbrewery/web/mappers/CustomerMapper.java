package com.newtondev.msscbrewery.web.mappers;

import com.newtondev.msscbrewery.domain.Customer;
import com.newtondev.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

}
