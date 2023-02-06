package com.felipe.address.controller;

import com.felipe.address.api.controller.Controller;
import com.felipe.address.api.converter.RequestBodyToAddressConverter;
import com.felipe.address.repository.Repository;
import com.felipe.address.service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ControllerTest {

    @Mock private Service service;
    @Mock private Repository repository;
    @Mock private RequestBodyToAddressConverter converter;
    @InjectMocks private Controller controller;

    @Test
    void shouldReturnHello() {
        controller.hello();

        verify(service).getHello();
    }

    @Test
    void shouldListAllAddress() {
        controller.listAllAddress();
    }

}