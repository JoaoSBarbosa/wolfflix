package com.barbosacode.admin.catalog.domain.validation.handler;

import com.barbosacode.admin.catalog.domain.exceptions.DomainException;
import com.barbosacode.admin.catalog.domain.validation.Error;
import com.barbosacode.admin.catalog.domain.validation.Validation;
import com.barbosacode.admin.catalog.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowValidationHandler implements ValidationHandler {
    @Override
    public List<Error> getErrors() {
        return List.of();
    }

    @Override
    public ValidationHandler append(final Error error) {

        throw DomainException.with(error);
    }

    @Override
    public ValidationHandler append(final ValidationHandler aHandler) {
        throw DomainException.with(aHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex) {
            Error error = new Error(ex.getMessage());
            throw DomainException.with(error);
        }
        return this;

    }


    @Override
    public boolean hasErrors() {
        return ValidationHandler.super.hasErrors();
    }
}
