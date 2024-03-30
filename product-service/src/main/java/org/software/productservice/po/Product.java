package org.software.productservice.po;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String productName;
    private Double price;
    private Long stock;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
