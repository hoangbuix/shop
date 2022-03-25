package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreateProductReq {
    private String productName;
    private String productCode;
    private String description;
    private String slug;
    private int brandId;
    private Double price;
    private String productImage;
    private int quantityProduct;
    private int totalProduct;
    private int totalSold;
    private int categoryId;
    private int productSize;
}
