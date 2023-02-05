package com.felipe.address.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestBody {

    @NotBlank
    @Size(max = 30)
    private String houseNumber;

    @NotBlank
    @Size(max = 400)
    private String street;

    @NotBlank
    @Size(max = 12)
    private String cep;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    @Size(max = 100)
    private String state;

    @NotBlank
    @Size(max = 50)
    private String country;

    @Size(max = 15)
    private String type;

}
