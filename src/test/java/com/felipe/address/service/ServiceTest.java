package com.felipe.address.service;

import com.felipe.address.repository.Repository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ServiceTest {

    @InjectMocks
    private Service service;

    @Mock
    private Repository repositoryMock;

}