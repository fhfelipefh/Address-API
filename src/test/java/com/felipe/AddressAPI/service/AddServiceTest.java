package com.felipe.AddressAPI.service;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.util.AddressCreator;
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

        BDDMockito.when(repositoryMock.save(address))
                .thenReturn(address);

    }

    @Test
    public void getAddressById() {
        BDDMockito.when(repositoryMock.findById(any()))
                .thenReturn(java.util.Optional.ofNullable(address));
        Assertions.assertEquals(address, addService.getAddressById(1L).get());
    }

    @Test
    public void getAddressListByCEP() {
        Assertions.assertEquals(2, addService.getAddressByCep("99999-999").size());
        Assertions.assertEquals(address, addService.getAddressByCep("99999-999").get(0));
        Assertions.assertEquals(address, addService.getAddressByCep("99999-999").get(1));
    }

    @Test
    public void saveAddress() {
        Assertions.assertEquals(address, addService.saveAddress(address));
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
        Assertions.assertEquals("Rua dos bobos",address.getStreet());
        Address newAddress = AddressCreator.createAddress();
        newAddress.setStreet("Rua de teste");
        addService.updaterAddress(newAddress);

        BDDMockito.when(repositoryMock.save(any()))
                .thenReturn(newAddress);

        BDDMockito.when(repositoryMock.findById(1L))
                .thenReturn(Optional.of(newAddress));

        Assertions.assertEquals("Rua de teste",addService.getAddressById(1L).get().getStreet());
    }




}