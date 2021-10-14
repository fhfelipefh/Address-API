package com.felipe.AddressAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.AddressAPI.address.Address;
import com.felipe.AddressAPI.address.Repository;
import com.felipe.AddressAPI.service.AddService;
import com.felipe.AddressAPI.util.AddressCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@WebMvcTest
public class AddControllerTest {

    @Autowired
    private AddController addController;

    @MockBean
    private AddService addServiceMock;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.addController);
    }


    @Test
    public void shouldReturnBikeById() {

        when(this.addServiceMock.getAddressById(1L))
                .thenReturn(new Address() = AddressCreator.createAddress());

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }


}
