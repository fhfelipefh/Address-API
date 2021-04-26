package com.felipe.AddressAPI.service;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.exception.AddressAPIException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Addservice {

    private Repository repository;

    public Optional<Address> get(Long id){
        return this.repository.findById(id);
    }

    public Addservice(Repository repository) { this.repository = repository; }

    public Optional<Address> getid(Long id) { return this.repository.findById(id); }

    public Address include(Address address) {
        if (address.getId() != null) {
            throw new AddressAPIException("Address", "include", address.getId());
        }
        return this.repository.save(address);
    }

    public void exclude(Long id) {
        this.repository.deleteById(id);
    }

    public Address updaterHouseNumber(Long id, Address address) {
        Address addressup = get(id)
                .orElseThrow(() -> new AddressAPIException("Address", "update", id));
        addressup.setHouseNumber(address.getHouseNumber());
        return this.repository.save(addressup);
    }

    public List<Address> getBycep(String cep) { return this.repository.findByCepContains(cep); }

    public void editcep(Long id, Address cep) {
        final Address newcep = repository.findById(id).orElseThrow(() -> new RuntimeException("Cep empty"));
        newcep.setCep(cep.getCep());
        repository.save(newcep);
    }

    //list all
    public List<Address> listall() {
        return this.repository.findAll();
    }

}
