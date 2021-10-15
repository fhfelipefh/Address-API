package com.felipe.address.api.util;

import com.felipe.address.api.address.Address;
import com.felipe.address.api.enums.DescriptionType;

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
        address.setType(DescriptionType.HOME);
        return address;
    }

    public static Address createAddress2() {
        Address address = new Address();
        address.setId(2L);
        address.setHouseNumber("0");
        address.setStreet("Rua dos bobos");
        address.setCep("99999999");
        address.setCity("Passo Fundo");
        address.setState("RS");
        address.setCountry("Brazil");
        address.setType(DescriptionType.HOME);
        return address;
    }

}
