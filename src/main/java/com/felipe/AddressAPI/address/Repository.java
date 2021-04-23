package com.felipe.AddressAPI.address;

import com.felipe.AddressAPI.enums.descriptiontype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Address, Long> {

    List<Address> findByCepContains(String cep);
}
