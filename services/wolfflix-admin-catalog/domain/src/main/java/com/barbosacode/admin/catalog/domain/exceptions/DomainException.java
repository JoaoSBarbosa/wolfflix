package com.barbosacode.admin.catalog.domain.exceptions;

import com.barbosacode.admin.catalog.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStacktraceException {

    private final List<Error> errors;

    private DomainException(String message, List<Error> aErrors) {
        super(message);
        this.errors = aErrors;
    }

    public static DomainException with(final List<Error> aErrors) {
        return new DomainException("", aErrors);
    }

    public static DomainException with(final Error aError) {

        return new DomainException(aError.message(), List.of(aError));
    }

    public List<Error> getErrors() {
        return errors;
    }
}
