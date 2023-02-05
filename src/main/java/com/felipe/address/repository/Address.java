package com.felipe.address.repository;

import com.felipe.address.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Type type;

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
