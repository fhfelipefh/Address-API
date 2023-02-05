package com.felipe.address.api.converter;

import com.felipe.address.api.model.AddressRequestBody;
import com.felipe.address.enums.Type;
import com.felipe.address.repository.Address;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class RequestBodyToAddressConverter {

    public Address toAddress(@NonNull AddressRequestBody addressRequestBody) {
        return Address.builder()
                .houseNumber(addressRequestBody.getHouseNumber())
                .street(addressRequestBody.getStreet())
                .cep(addressRequestBody.getCep())
                .city(addressRequestBody.getCity())
                .state(addressRequestBody.getState())
                .country(addressRequestBody.getCountry())
                .type(toDescriptionType(addressRequestBody.getType()))
                .build();
    }

    private Type toDescriptionType(String type) {
        try {
            type = type == null ? "" : type.toUpperCase();
            return Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            return Type.UNDEFINED;
        }
    }

}
