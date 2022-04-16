package com.hoangbui.shopping.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "description")
    private String description;

    @Column(name = "slug")
    private String slug;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "quantity_product")
    private int quantityProduct;

    @Column(name = "total_product")
    private int totalProduct;

    @Column(name = "total_sold")
    private int totalSold;

    // @Column(name = "brand_id")
    // @OneToMany(mappedBy = "brand")
    // private int brandId;

    // private Set<BrandEntity> brand;

    // @Column(name = "category_id")
    // private int categoryId;

    // private Set<CategoryEntity> category;

    // @Column(name = "product_size")
    // private int productSize;

//    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

//    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductSizeEntity productSize;
}