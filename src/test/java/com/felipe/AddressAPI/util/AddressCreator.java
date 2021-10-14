package com.felipe.AddressAPI.util;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.enums.descriptionType;

public class AddressCreator {

    public static Address createAddress() {
        Address address = new Address();
        address.setId(1L);
        address.setHouseNumber("0");
        address.setStreet("Rua dos bobos");
        address.setCep("99999-999");
        address.setCity("Passo Fundo");
        address.setState("RS");
        address.setCountry("Brazil");
        address.setType(descriptionType.HOME);
        return address;
    }

    public static Address createAddress2() {
        Address address = new Address();
        address.setId(2L);
        address.setHouseNumber("0");
        address.setStreet("Rua dos bobos");
        address.setCep("99999-999");
        address.setCity("Passo Fundo");
        address.setState("RS");
        address.setCountry("Brazil");
        address.setType(descriptionType.HOME);
        return address;
    }

}
