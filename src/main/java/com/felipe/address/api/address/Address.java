package com.felipe.address.api.address;

import com.felipe.address.api.enums.DescriptionType;
import com.felipe.address.api.exception.AddressAPIException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;


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

    @NotNull
    @Enumerated(STRING)
    @Column(nullable = false)
    private DescriptionType type;

    public DescriptionType getType() {
        return type;
    }

    public void setType(DescriptionType type) {
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

    public List<AddressAPIException> emptyFieldsVerify(Address address) {
        List<AddressAPIException> exceptions = new ArrayList<>();
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
            exceptions.add(new AddressAPIException("null State"));
        }
        if (address.getCountry() == null) {
            exceptions.add(new AddressAPIException("Null Country"));
        }
        if (address.getType() == null) {
            exceptions.add(new AddressAPIException("Null Type"));
        }
        return exceptions;
    }

    @Override
    public String toString() {
        return "Address{" +
               "id=" + id +
               ", houseNumber='" + houseNumber + '\'' +
               ", street='" + street + '\'' +
               ", cep='" + cep + '\'' +
               ", city='" + city + '\'' +
               ", state='" + state + '\'' +
               ", country='" + country + '\'' +
               ", type=" + type +
               '}';
    }
}
