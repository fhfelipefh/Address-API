package com.felipe.address.service;

import com.felipe.address.repository.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ServiceTest {

    private static final String HELLO = "<html><p>Hello, World!</p><p><b>Mais informações em:&nbsp;</b><a href='https://github.com/fhfelipefh/Address-API'>https://github.com/fhfelipefh/Address-API</a></p></html>";

    @Mock private Repository repositoryMock;
    @InjectMocks private Service service;

    @Test
    void shouldReturnHello() {
        String hello = service.getHello();

        assertEquals(HELLO, hello);
        verify(repositoryMock, never());
    }

}