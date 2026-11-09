package com.barbosacode.admin.catalog.domain.exceptions;
import com.barbosacode.admin.catalog.domain.validation.Error;

import java.util.List;

public class DomainException extends RuntimeException{

   private final List<Error> errors;

    private DomainException(List<Error> aErrors) {
        super("", null, true, false);
        this.errors = aErrors;
    }

    public  static DomainException with(final List<Error> aErrors) {
        return new DomainException(aErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
