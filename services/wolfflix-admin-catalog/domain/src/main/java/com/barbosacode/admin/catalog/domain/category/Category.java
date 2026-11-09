package com.barbosacode.admin.catalog.domain.category;
import com.barbosacode.admin.catalog.domain.category.validator.CategoryValidator;
import com.barbosacode.admin.catalog.domain.shared.AggregateRoot;
import com.barbosacode.admin.catalog.domain.category.vo.CategoryId;
import com.barbosacode.admin.catalog.domain.validation.ValidationHandler;

import java.time.Instant;


public class Category extends AggregateRoot<CategoryId> {
    private String name;
    private String description;
    private boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(
            final CategoryId anId,
            final String aName,
            final String aDescription,
            final boolean isActive,
            final Instant aCreatedAt,
            final Instant aUpdatedAt,
            final Instant aDeletedAt
    ) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.isActive = isActive;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
        this.deletedAt = aDeletedAt;
    }

    public static Category create(
            String name,
            String description,
            boolean isActive
    ) {

        final CategoryId id = CategoryId.unique();
        final Instant now = Instant.now();
        return new Category(id, name, description, isActive, now, now, null);

    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public CategoryId getId() {
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
