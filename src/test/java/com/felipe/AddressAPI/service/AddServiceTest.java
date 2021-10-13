package com.felipe.AddressAPI.service;

import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.util.AddressCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
public class AddServiceTest {

    @InjectMocks
    private AddService addService;

    @Mock
    private Repository repositoryMock;

    private Address address = AddressCreator.createAddressToBeSaved();

    @BeforeEach
    public void setUp() {
        BDDMockito.when(repositoryMock.findById(any()))
                .thenReturn(java.util.Optional.ofNullable(address));

        BDDMockito.when(repositoryMock.findByCepContains(anyString()))
                .thenReturn(List.of(address,address));

    }

    @Test
    public void getAddressById() {
        Assertions.assertEquals(address,addService.getAddressById(1L).get());
    }

    @Test
    public void getAddressListByCEP(){
        Assertions.assertEquals(2,addService.getAddressByCep("99999-999").size());
        Assertions.assertEquals(address,addService.getAddressByCep("99999-999").get(0));
        Assertions.assertEquals(address,addService.getAddressByCep("99999-999").get(1));
    }

}