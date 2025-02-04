package com.julian.springcloud.msvc.items.models;

import lombok.Data;

@Data
public class Item {
    private Product product;
    private int quantity;

    public Item() {
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Double getTotal() {
        return product.getPrice() * quantity;
    }
}
