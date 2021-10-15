package com.felipe.address.api.service;

import com.felipe.address.api.address.Address;
import com.felipe.address.api.address.Repository;
import com.felipe.address.api.exception.AddressAPIException;
import com.felipe.address.api.exception.IncompatibleDataForThisField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<IncompatibleDataForThisField> incompatibleDataForThisFieldList = dataFormatVerify(address);
        if (incompatibleDataForThisFieldList.size() >= 1) {
            throw new IncompatibleDataForThisField("Address not be saved: " + incompatibleDataForThisFieldList.toString());
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

    private List<IncompatibleDataForThisField> dataFormatVerify(Address address) {
        List<IncompatibleDataForThisField> incompatibleDataForThisFieldList = new ArrayList<>();
        if (address.getCep().length() > 8) {
            incompatibleDataForThisFieldList.add(new IncompatibleDataForThisField("CEP must only contain 8 numbers"));
        }
        if(address.getState().length() > 2){
            incompatibleDataForThisFieldList.add(new IncompatibleDataForThisField("STATE not valid"));
        }
        return incompatibleDataForThisFieldList;
    }

}
