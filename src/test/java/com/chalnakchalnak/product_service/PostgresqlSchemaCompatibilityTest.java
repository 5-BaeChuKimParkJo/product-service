package com.chalnakchalnak.product_service;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.DealCompleteEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PostgresqlSchemaCompatibilityTest {

    @Test
    void entitiesDoNotDeclareMysqlOnlyColumnTypes() {
        Stream.of(ProductEntity.class, DealCompleteEntity.class)
                .flatMap(type -> Arrays.stream(type.getDeclaredFields()))
                .map(field -> field.getAnnotation(Column.class))
                .filter(annotation -> annotation != null)
                .map(Column::columnDefinition)
                .forEach(definition -> assertTrue(
                        !definition.toUpperCase().contains("DATETIME")
                                && !definition.toUpperCase().contains("LONGTEXT"),
                        () -> "MySQL-only column definition: " + definition));
    }
}
