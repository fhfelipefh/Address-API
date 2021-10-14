package com.felipe.AddressAPI.service;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.exception.AddressAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddService {

    @Autowired
    private Repository repository;

    public AddService(Repository repository) {
        this.repository = repository;
    }

    public Optional<Address> getAddressById(Long id) {
        return this.repository.findById(id);
    }

    public Address saveAddress(Address address) {
        if (address.getId() == null || address.getCep() == null) {
            throw new AddressAPIException("Address", "saveAddress", address.getId());
        }
        return this.repository.save(address);
    }

    public void deleteAddressById(Long id) {
        this.repository.deleteById(id);
    }

    public Address updaterAddress(Address address) {
        ArrayList<AddressAPIException> exceptionArrayList = address.emptyFieldsVerify(address);
        if (exceptionArrayList.size() >= 1) {
            throw new AddressAPIException("Address", "update not allowed" + exceptionArrayList.toString(), address.getId());
        }
        deleteAddressById(address.getId());
        return this.repository.save(address);
    }

    public List<Address> getAddressByCep(String cep) {
        return this.repository.findByCepContains(cep);
    }

    public void updateCep(Long id, Address cep) {
        final Address newCep = repository.findById(id).orElseThrow(() -> new RuntimeException("Cep empty"));
        newCep.setCep(cep.getCep());
        repository.save(newCep);
    }

    public List<Address> listAll() {
        return this.repository.findAll();
    }


}
