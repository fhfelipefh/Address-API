package com.felipe.address.api.service;

import com.felipe.address.api.address.Address;
import com.felipe.address.api.address.Repository;
import com.felipe.address.api.exception.AddressAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddService {
    
    private final Repository repository;
    private static final Logger logger = LoggerFactory.getLogger(AddService.class);
    
    @Autowired
    public AddService(Repository repository) {
        this.repository = repository;
    }
    
    public Optional<Address> getAddressById(Long id) {
        return this.repository.findById(id);
    }
    
    public Address saveAddress(Address address) {
        List<AddressAPIException> exceptionArrayList = address.emptyFieldsVerify(address);
        if (exceptionArrayList.size() >= 1) {
            throw new AddressAPIException("Address", "save not allowed" + exceptionArrayList.toString(), address.getId());
        }
        return this.repository.save(address);
    }
    
    public void deleteAddressById(Long id) {
        this.repository.deleteById(id);
    }
    
    public Address updaterAddress(Address address) {
        List<AddressAPIException> exceptionArrayList = address.emptyFieldsVerify(address);
        if (exceptionArrayList.size() >= 1) {
            throw new AddressAPIException("Address", "update not allowed" + exceptionArrayList.toString(), address.getId());
        }
        deleteAddressById(address.getId());
        return this.repository.save(address);
    }
    
    public List<Address> getAddressByCep(String cep) {
        return this.repository.findByCepContains(cep);
    }
    
    public List<Address> listAll() {
        return this.repository.findAll();
    }
    
    
}
