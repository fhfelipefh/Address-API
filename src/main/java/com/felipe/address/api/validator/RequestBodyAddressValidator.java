package com.felipe.address.api.validator;

import com.felipe.address.api.model.AddressRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Component
@RequiredArgsConstructor
public class RequestBodyAddressValidator {

    private final Validator validator;

    public void throwViolationIfInvalid(AddressRequestBody addressRequestBody) {
        final Set<ConstraintViolation<AddressRequestBody>> errors = validator.validate(addressRequestBody);
        if (isNotEmpty(errors)) throw new ConstraintViolationException(errors);
    }

}