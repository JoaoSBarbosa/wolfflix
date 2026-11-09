package com.barbosacode.admin.catalog.domain;

import com.barbosacode.admin.catalog.domain.category.Category;
import com.barbosacode.admin.catalog.domain.exceptions.DomainException;
import com.barbosacode.admin.catalog.domain.validation.handler.ThrowValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryTest {



    @Test
    @DisplayName("Deve criar uma categoria quando os parâmetros forem válidos")
    public void shouldCreateCategoryWhenValidParams(){

        final String name = "Ação e Aventura";
        final String description = "A categoria mais assistida";
        final boolean isActive = true;

        final Category category = Category.create(name, description, isActive);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(name, category.getName());
        Assertions.assertEquals(description, category.getDescription());
        Assertions.assertEquals(isActive, category.isActive());

    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o nome for nulo")
    public void shouldExceptionWhenNameIsNull(){
        final String expectedName = null;
        final int expectedErrorCount = 1;
        final String expectedErrorMessage = "'Nome' da categoria não deve ser nulo ou vazio";
        final String description = "A categoria mais assistida";
        final boolean isActive = true;

        final Category actualCategory = Category.create(expectedName, description, isActive);
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowValidationHandler()));


        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
}
