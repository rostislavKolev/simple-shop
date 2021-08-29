package com.task.simpleshop.dto;

public class ProductDto extends BaseDto {

    private static final long serialVersionUID = 8280830917493823047L;

    private String productId;

    private String name;

    private Boolean isAvailable;

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

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }
}
