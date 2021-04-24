package com.felipe.AddressAPI.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Address, Long> {

    List<Address> findByCepContains(String cep);
}
