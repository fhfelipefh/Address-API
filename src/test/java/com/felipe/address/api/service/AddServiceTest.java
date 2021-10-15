package com.felipe.address.api.service;

import com.felipe.address.api.address.Address;
import com.felipe.address.api.address.Repository;
import com.felipe.address.api.exception.AddressAPIException;
import com.felipe.address.api.exception.IncompatibleDataForThisField;
import com.felipe.address.api.util.AddressCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
public class AddServiceTest {

    @InjectMocks
    private AddService addService;

    @Mock
    private Repository repositoryMock;

    private Address address = AddressCreator.createAddress();

    @BeforeEach
    public void setUp() {

        BDDMockito.when(repositoryMock.findByCepContains(anyString()))
                .thenReturn(List.of(address, address));


        BDDMockito.when(repositoryMock.findAll())
                .thenReturn(List.of(address, address, address));
    }

    @Test
    public void getAddressById() {
        BDDMockito.when(repositoryMock.findById(any()))
                .thenReturn(java.util.Optional.ofNullable(address));
        Assertions.assertEquals(address, addService.getAddressById(1L).get());
    }

    @Test
    public void getAddressListByCEP() {
        Assertions.assertEquals(2, addService.getAddressByCep("99999999").size());
        Assertions.assertEquals(address, addService.getAddressByCep("99999999").get(0));
        Assertions.assertEquals(address, addService.getAddressByCep("99999999").get(1));
    }

    @Test
    public void saveAddress() {
        BDDMockito.when(repositoryMock.save(address))
                .thenReturn(address);
        Assertions.assertEquals(address, addService.saveAddress(address));
    }

    @Test
    public void shouldNotSaveAddressWithNullFields() {
        BDDMockito.when(repositoryMock.save(any()))
                .thenReturn(address);

        Address address = AddressCreator.createAddress();
        address.setCep(null);
        Exception exception = assertThrows(AddressAPIException.class, () -> addService.saveAddress(address));
        String expectedMessage = "Erro em objeto do tipo Address ao executar save not allowed[com.felipe.address.api.exception.AddressAPIException: Null CEP] com id 1.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldNotSaveAddressWithInvalidCEPData() {
        BDDMockito.when(repositoryMock.save(any()))
                .thenReturn(address);

        Address address = AddressCreator.createAddress();
        address.setCep("123456789");
        Exception exception = assertThrows(IncompatibleDataForThisField.class, () -> addService.saveAddress(address));
        String expectedMessage = "Address not be saved: [com.felipe.address.api.exception.IncompatibleDataForThisField: CEP must only contain 8 numbers]";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldNotSaveAddressWithInvalidStateData() {
        BDDMockito.when(repositoryMock.save(any()))
                .thenReturn(address);

        Address address = AddressCreator.createAddress();
        address.setState("dasdsadasfasf");
        Exception exception = assertThrows(IncompatibleDataForThisField.class, () -> addService.saveAddress(address));
        String expectedMessage = "Address not be saved: [com.felipe.address.api.exception.IncompatibleDataForThisField: STATE not valid]";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void deleteAddress() {
        Address addressToDelete = AddressCreator.createAddress();
        Assertions.assertEquals(1L, addressToDelete.getId());
        addService.deleteAddressById(1L);
        Assertions.assertEquals(Optional.empty(), addService.getAddressById(1L));
    }

    @Test
    public void updateAddress() {
        BDDMockito.when(repositoryMock.save(any()))
                .thenReturn(address);

        addService.saveAddress(address);
        Assertions.assertEquals("Rua dos bobos", address.getStreet());
        Address newAddress = AddressCreator.createAddress();
        newAddress.setStreet("Rua de teste");
        addService.updaterAddress(newAddress);

        BDDMockito.when(repositoryMock.save(any()))
                .thenReturn(newAddress);

        BDDMockito.when(repositoryMock.findById(1L))
                .thenReturn(Optional.of(newAddress));

        Assertions.assertEquals("Rua de teste", addService.getAddressById(1L).get().getStreet());
    }

    @Test
    public void shouldNotUpdateAddressWithNullFields() {
        Address address = AddressCreator.createAddress();
        address.setCity(null);
        Exception exception = assertThrows(AddressAPIException.class, () -> addService.updaterAddress(address));
        String expectedMessage = "Erro em objeto do tipo Address ao executar update not allowed[com.felipe.address.api.exception.AddressAPIException: Null City] com id 1.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void listAllAddress() {
        Assertions.assertEquals(3, addService.listAll().size());
    }



}