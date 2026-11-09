package com.barbosacode.admin.catalog.domain.shared;

import com.barbosacode.admin.catalog.domain.validation.ValidationHandler;

import java.util.Objects;

public abstract class Entity<ID extends Identifier> {

    protected final ID id;

    protected Entity(final ID id) {

        Objects.requireNonNull(id,"ID não pode ser nulo");
        this.id = id;
    }

    public abstract void validate(ValidationHandler handler);

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Entity<?> entity = (Entity<?>) object;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }

    public ID getId() {
        return id;
    }
}
