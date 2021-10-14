package com.felipe.address.api.controller;

import com.felipe.address.api.address.Address;
import com.felipe.address.api.service.AddService;
import com.felipe.address.api.util.AddressCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AddController.class)
public class AddControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddService addService;

    private List<Address> addressList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Address addressTest = AddressCreator.createAddress();
        addressList.add(addressTest);
        Address addressTest1 = AddressCreator.createAddress();
        addressList.add(addressTest1);
        Address addressTest2 = AddressCreator.createAddress();
        addressList.add(addressTest2);
    }



}