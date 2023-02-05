package com.felipe.address.api.controller;

import com.felipe.address.api.converter.RequestBodyToAddressConverter;
import com.felipe.address.api.model.AddressRequestBody;
import com.felipe.address.api.validator.RequestBodyAddressValidator;
import com.felipe.address.repository.Address;
import com.felipe.address.repository.Repository;
import com.felipe.address.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("/address")
public class Controller {

    private final Repository repository;
    private final Service service;
    private final RequestBodyToAddressConverter converter;
    private final RequestBodyAddressValidator validator;

    public Controller(Repository repository, Service service, RequestBodyToAddressConverter converter, RequestBodyAddressValidator validator) {
        this.repository = repository;
        this.service = service;
        this.converter = converter;
        this.validator = validator;
    }

    @GetMapping("")
    public String hello() {
        return service.getHello();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> listAllAddress() {
        log.info("Listing all addresses");
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping("/")
    public ResponseEntity<Address> saveAddress(@RequestBody AddressRequestBody requestBody) {
        log.info("Saving address: " + requestBody.toString());
        validator.throwViolationIfInvalid(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAddress(converter.toAddress(requestBody)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddressById(@PathVariable Long id) {
        service.deleteAddressById(id);
        log.info("Address deleted: " + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cep")
    public ResponseEntity<List<Address>> findAddressByCep(@RequestParam("cep") String cep) {
        log.info("Searching address by CEP: " + cep);
        return ResponseEntity.ok(repository.findByCepContains(cep));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> optionalAddress = service.getAddressById(id);
        log.info("Searching address by ID: " + id);
        return optionalAddress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody AddressRequestBody requestBody, @PathVariable Long id) {
        validator.throwViolationIfInvalid(requestBody);
        log.info("Updating address: " + id);
        return service.updateAddress(converter.toAddress(requestBody), id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

}
