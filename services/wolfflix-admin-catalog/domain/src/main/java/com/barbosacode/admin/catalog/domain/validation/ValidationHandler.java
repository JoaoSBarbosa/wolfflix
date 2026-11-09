package com.barbosacode.admin.catalog.domain.validation;

import java.util.List;

public interface ValidationHandler {


    List<Error> getErrors();
    ValidationHandler append(Error error);
    ValidationHandler append(ValidationHandler aHandler);
    ValidationHandler validate(Validation aValidation);

    default boolean hasErrors() {
        return getErrors() != null && !getErrors().isEmpty();
    }
}
