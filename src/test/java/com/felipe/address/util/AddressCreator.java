package com.felipe.address.util;

import com.felipe.address.repository.Address;
import com.felipe.address.enums.Type;

public class AddressCreator {

    public static Address createAddress() {
        Address address = new Address();
        address.setId(1L);
        address.setHouseNumber("0");
        address.setStreet("Rua dos bobos");
        address.setCep("99999999");
        address.setCity("Passo Fundo");
        address.setState("RS");
        address.setCountry("Brazil");
        address.setType(Type.HOME);
        return address;
    }

}
