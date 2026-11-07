package com.barbosacode.admin.catalog.domain.category;

import java.util.UUID;

public class Category {
    private String id;
    private String name;
    private String description;
    private boolean isActive;


    private Category(String id, String name, String description, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

    public static Category create(String name, String description, boolean isActive) {

        final String id = UUID.randomUUID().toString();
        return new Category(id, name, description, isActive);

    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
