package com.hoangbui.shopping.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orders")
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    @Column(name = "note")
    private String note;

    @Column(name = "product_price")
    private float productPrice;

    // @JoinColumn(name = "promotion_id")
    // @ManyToOne(fetch = FetchType.LAZY)
    // private PromotionEntity promotion;

    @Column(name = "promotion_id")
    private int promotionId;

    @Column(name = "product_id")
    private int productId;

    @Column(name="product_size")
    private int productSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_address")
    private String receiverAddress;

    @Column(name = "receiver_phone")
    private String receiverPhone;

    @Column(name = "status")
    private String status;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "buyer")
    private int buyer;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "modified_by")
    private int modifiedBy;
}