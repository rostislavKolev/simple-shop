package com.task.simpleshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BasicEntity {

    private static final long serialVersionUID = 3054137640848887827L;

    @Column(name = "product_id", nullable = false, unique = true)
    private String productId;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
