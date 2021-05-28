package com.felipe.AddressAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.exception.AddressAPIException;
import com.felipe.AddressAPI.service.Addservice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.path;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Addcontroller.class)
public class AddcontrollerTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private Address address;

    private List<Address> addressList = new ArrayList<>();

    @MockBean
    private Addcontroller addcontroller;
    @MockBean
    private Repository repository;

    @MockBean
    private Addservice addService;

    public AddcontrollerTest() {
    }

    @BeforeEach
    public void setUp(){
        Address addressFAKE = new Address();
        addressFAKE.setId(1L);
        addressFAKE.setHouseNumber("155");
        addressFAKE.setStreet("Rua de Schrödinger");
        addressFAKE.setCep("99999999");
        addressFAKE.setCity("Paradise City");
        addressFAKE.setState("RS");
        addressFAKE.setCountry("Brazil");
        addressList.add(addressFAKE);
    }

    @Test
    public void getempty() throws Exception {
        mockMvc.perform(get("/5"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }




}
