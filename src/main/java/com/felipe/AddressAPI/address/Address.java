package com.felipe.AddressAPI.address;

import com.felipe.AddressAPI.enums.descriptionType;
import com.felipe.AddressAPI.exception.AddressAPIException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Objects;


@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String houseNumber;

    @NotBlank
    private String street;

    @NotBlank
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(nullable = false)
    private String state;

    @NotBlank
    @Column(nullable = false)
    private String country;

    @NotBlank
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private descriptionType type;

    public descriptionType getType() {
        return type;
    }

    public void setType(descriptionType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(street, address.street) && Objects.equals(cep, address.cep) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(country, address.country) && type == address.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, houseNumber, street, cep, city, state, country, type);
    }

    public ArrayList<AddressAPIException> emptyFieldsVerify(Address address) {
        ArrayList<AddressAPIException> exceptions = new ArrayList();
        if (address.getId() == null) {
            exceptions.add(new AddressAPIException("Null ID"));
        }
        if (address.getHouseNumber() == null) {
            exceptions.add(new AddressAPIException("Null House Number"));
        }
        if (address.getStreet() == null) {
            exceptions.add(new AddressAPIException("Null Street"));
        }
        if (address.getCep() == null) {
            exceptions.add(new AddressAPIException("Null CEP"));
        }
        if (address.getCity() == null) {
            exceptions.add(new AddressAPIException("Null City"));
        }
        if (address.getState() == null) {
            exceptions.add(new AddressAPIException("Null State"));
        }
        if (address.getCountry() == null) {
            exceptions.add(new AddressAPIException("Null Country"));
        }
        if (address.getType() == null) {
            exceptions.add(new AddressAPIException("Null Type"));
        }
        return exceptions;
    }


}
