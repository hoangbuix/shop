package com.hoangbui.shopping.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity(name = "category")
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Column(name = "category_name")
    private String categoryName;

    @Column(name="category_code")
    private String categoryCode;

    @Column(name = "description")
    private String description;
}
