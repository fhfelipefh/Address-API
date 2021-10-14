package com.felipe.AddressAPI.controller;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddController {

    private Repository repository;
    private final AddService addservice;

    @Autowired
    public AddController(Repository repository, AddService addservice) {
        this.repository = repository;
        this.addservice = addservice;
    }

    //GET init
    @GetMapping("")
    String hello() {
        return "<html><p>Hello, World!</p><p><b>Mais informações em:&nbsp;</b><a href='https://github.com/fhfelipefh/Address-API'>https://github.com/fhfelipefh/Address-API</a></p></html>";
    }

    //Get ALL
    @GetMapping("/all")
    public ResponseEntity<List<Address>> listall() {
        return ResponseEntity.ok(addservice.listAll());
    }

    //POST
    @PostMapping("/")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addservice.saveAddress(address));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> exclude(@PathVariable Long id) {
        addservice.deleteAddressById(id);
        return ResponseEntity.ok().build();
    }

    //Find by cep ex: localhost:8081/address/cep?cep=99
    @GetMapping("/cep")
    public ResponseEntity<List<Address>> findAddressByCep(@RequestParam("cep") String cep) {
        return ResponseEntity.ok(repository.findByCepContains(cep));
    }

    //Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Optional<Address> opaddress = addservice.getAddressById(id);
        if (opaddress.isPresent()) {
            return ResponseEntity.ok(opaddress.get());
        }
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("/put/{id}")
    public ResponseEntity<Address> updater(@RequestBody Address address) {
        if (addservice.updaterAddress(address) == address) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}
