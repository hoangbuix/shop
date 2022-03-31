package com.hoangbui.shopping.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "product_size")
@Table(name = "product_size")
public class ProductSizeEntity extends BaseEntity {
    @Column(name = "size")
    private String size;

    @Column(name = "size_code")
    private String sizeCode;

    @Column(name = "quantity")
    private String quantity;

    @Column(name="gender")
    private String gender;
}
