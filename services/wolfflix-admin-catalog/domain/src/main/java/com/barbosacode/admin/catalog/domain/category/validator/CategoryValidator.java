package com.barbosacode.admin.catalog.domain.category.validator;

import com.barbosacode.admin.catalog.domain.category.Category;
import com.barbosacode.admin.catalog.domain.validation.Error;
import com.barbosacode.admin.catalog.domain.validation.ValidationHandler;
import com.barbosacode.admin.catalog.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;

    public CategoryValidator(
            final Category aCategory,
            final ValidationHandler aHandler
    ) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {

        if (this.category == null) {
            validationHandler().append(new Error("'Categoria' não deve ser nula"));
            return;
        }
        if (this.category.getName() == null || this.category.getName().isBlank()) {
            validationHandler().append(new Error("'Nome' da categoria não deve ser nulo ou vazio"));
            return;
        }

        if (this.category.getName() != null && this.category.getName().length() > 255) {
            validationHandler().append(new Error("'Nome' da categoria não deve ter mais de 255 caracteres"));
            return;
        }
    }
}
