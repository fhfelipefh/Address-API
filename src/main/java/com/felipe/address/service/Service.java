package com.felipe.address.service;

import com.felipe.address.repository.Address;
import com.felipe.address.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private static final String HELLO = "<html><p>Hello, World!</p><p><b>Mais informações em:&nbsp;</b><a href='https://github.com/fhfelipefh/Address-API'>https://github.com/fhfelipefh/Address-API</a></p></html>";

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public String getHello() {
        return HELLO;
    }

    public Optional<Address> getAddressById(Long id) {
        return this.repository.findById(id);
    }

    public Address saveAddress(Address address) {
        return this.repository.save(address);
    }

    public void deleteAddressById(Long id) {
        this.repository.deleteById(id);
    }

    public Optional<Address> updateAddress(Address address, Long id) {
        Optional<Address> optionalAddress = this.repository.findById(id);
        if (optionalAddress.isPresent()) {
            return Optional.of(this.repository.save(address));
        }
        return Optional.empty();
    }

    public List<Address> getAddressByCep(String cep) {
        return this.repository.findByCepContains(cep);
    }

    public List<Address> listAll() {
        return this.repository.findAll();
    }

}
