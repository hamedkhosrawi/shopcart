package org.acme.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.acme.entity.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter @NoArgsConstructor
@Entity @ToString(callSuper = true)
@Table(name = "products")
public class Product extends AbstractEntity {


    @NotNull
    private String name;
    private String description;
    private BigDecimal price;
    private ProductStatus status;
    private Integer salesCounter;

    private Set<Review> reviews = new HashSet<>();

}
