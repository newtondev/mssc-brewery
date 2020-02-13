package com.newtondev.msscbrewery.web.controller;

import com.newtondev.msscbrewery.services.CustomerService;
import com.newtondev.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull  @PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new customer
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody CustomerDto customerDto) {
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedDto.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@NotNull @PathVariable("customerId") UUID customerId, @Valid @NotNull @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@NotNull @PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }
}
