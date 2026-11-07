package com.barbosacode.admin.catalog.domain.category.vo;
import com.barbosacode.admin.catalog.domain.shared.Identifier;
import java.util.Objects;
import java.util.UUID;

public class CategoryId extends Identifier {


    private final String value;

    private CategoryId(String value) {

        Objects.requireNonNull(value,"ID da categoria não pode ser nulo");
        this.value = value;
    }

    public static CategoryId unique(){
        return  CategoryId.from(UUID.randomUUID());
    }

    public static CategoryId from( final String anId){

        return new CategoryId(anId);
    }

    public static CategoryId from(UUID anId){
        return new CategoryId(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        CategoryId that = (CategoryId) object;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CategoryId{" +
                "value='" + value + '\'' +
                '}';
    }
}
