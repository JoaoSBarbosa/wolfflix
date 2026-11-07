package com.barbosacode.admin.catalog.domain;

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
}
