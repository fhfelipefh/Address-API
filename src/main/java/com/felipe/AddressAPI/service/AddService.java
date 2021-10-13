package com.felipe.AddressAPI.service;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.exception.AddressAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddService {

    @Autowired
    private Repository repository;

    public AddService(Repository repository) {
        this.repository = repository;
    }

    public Optional<Address> get(Long id) {
        return this.repository.findById(id);
    }

    public Optional<Address> getId(Long id) {
        return this.repository.findById(id);
    }

    public Address saveAddress(Address address) {
        if (address.getId() != null) {
            throw new AddressAPIException("Address", "saveAddress", address.getId());
        }
        return this.repository.save(address);
    }

    public void deleteAddressById(Long id) {
        this.repository.deleteById(id);
    }

    public Address updaterAddress(Long id, Address address) {
        if (!get(address.getId()).isPresent()) {
            new AddressAPIException("Address", "update", id);
        }
        return this.repository.save(address);
    }

    public List<Address> getAddressByCep(String cep) {
        return this.repository.findByCepContains(cep);
    }

    public void updateCep(Long id, Address cep) {
        final Address newcep = repository.findById(id).orElseThrow(() -> new RuntimeException("Cep empty"));
        newcep.setCep(cep.getCep());
        repository.save(newcep);
    }

    public List<Address> listAll() {
        return this.repository.findAll();
    }

}
