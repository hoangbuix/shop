package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.ProductSizeDAO;
import com.hoangbui.shopping.entity.ProductSizeEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateProductSizeReq;
import com.hoangbui.shopping.model.req.update.UpdateProductSizeReq;
import com.hoangbui.shopping.service.ProductSizeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSizeServiceImpl implements ProductSizeService {
    final Logger log = Logger.getLogger(ProductSizeServiceImpl.class);

    @Autowired
    private ProductSizeDAO<ProductSizeEntity> productSizeDAO;

    @Override
    public ProductSizeEntity save(CreateProductSizeReq req) {
        int id = 0;
        try {
            ProductSizeEntity check = productSizeDAO.findBySizeCodeAndGender(req.getSizeCode(), req.getGender());
            if (check != null) {
                throw new DuplicateRecordException("exist");
            } else {
                ProductSizeEntity productSize = new ProductSizeEntity();
                switch (req.getGender()) {
                    case "Male":
                        switch (req.getSizeCode()) {
                            case "XS":
                                productSize.setSize("Extra Small");
                                productSize.setQuantity("40-55");
                                break;
                            case "S":
                                productSize.setSize("Small");
                                productSize.setQuantity("55-60");
                                break;
                            case "M":
                                productSize.setSize("Medium");
                                productSize.setQuantity("60-65");
                                break;
                            case "L":
                                productSize.setSize("Large");
                                productSize.setQuantity("66-70");
                                break;
                            case "XL":
                                productSize.setSize("Extra Large");
                                productSize.setQuantity("70-76");
                                break;
                            case "XXL":
                                productSize.setSize("Double Extra Large");
                                productSize.setQuantity("70-80");
                                break;
                            default:
                                productSize.setSize(req.getSize());
                                productSize.setQuantity(req.getQuantity());
                                break;
                        }
                        productSize.setSizeCode(req.getSizeCode());
                        productSize.setGender("Male");
                        break;
                    case "Female":
                        switch (req.getSizeCode()) {
                            case "XS":
                                productSize.setSize("Extra Small");
                                productSize.setQuantity("30-38");
                                break;
                            case "S":
                                productSize.setSize("Small");
                                productSize.setQuantity("38-43");
                                break;
                            case "M":
                                productSize.setSize("Medium");
                                productSize.setQuantity("43-46");
                                break;
                            case "L":
                                productSize.setSize("Large");
                                productSize.setQuantity("46-53");
                                break;
                            case "XL":
                                productSize.setSize("Extra Large");
                                productSize.setQuantity("53-57");
                                break;
                            case "XXL":
                                productSize.setSize("Double Extra Large");
                                productSize.setQuantity("57-66");
                                break;
                            default:
                                productSize.setQuantity(req.getQuantity());
                                productSize.setSize(req.getSize());
                                break;
                        }
                        productSize.setSizeCode(req.getSizeCode());
                        productSize.setGender("Female");
                        break;
                    default:
                        productSize.setSize(req.getSize());
                        productSize.setSizeCode(req.getSizeCode());
                        productSize.setQuantity(req.getQuantity());
                        productSize.setGender(req.getGender());
                        break;
                }
                id = productSizeDAO.save(productSize);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return productSizeDAO.findById(id);
    }



    @Override
    public ProductSizeEntity update(UpdateProductSizeReq req) {
        ProductSizeEntity productSize = new ProductSizeEntity();
        productSize.setId(req.getId());
        try {
            switch (req.getGender()) {
                case "Male":
                    switch (req.getSizeCode()) {
                        case "XS":
                            productSize.setSize("Extra Small");
                            productSize.setQuantity("40-55");
                            break;
                        case "S":
                            productSize.setSize("Small");
                            productSize.setQuantity("55-60");
                            break;
                        case "M":
                            productSize.setSize("Medium");
                            productSize.setQuantity("60-65");
                            break;
                        case "L":
                            productSize.setSize("Large");
                            productSize.setQuantity("66-70");
                            break;
                        case "XL":
                            productSize.setSize("Extra Large");
                            productSize.setQuantity("70-76");
                            break;
                        case "XXL":
                            productSize.setSize("Double Extra Large");
                            productSize.setQuantity("70-80");
                            break;
                        default:
                            productSize.setSize("");
                            productSize.setQuantity("");
                            break;
                    }
                    productSize.setActiveFlag(req.getActiveFlag());
                    productSize.setSizeCode(req.getSizeCode());
                    productSize.setGender("Male");
                    break;
                case "Female":
                    switch (req.getSizeCode()) {
                        case "XS":
                            productSize.setSize("Extra Small");
                            productSize.setQuantity("30-38");
                            break;
                        case "S":
                            productSize.setSize("Small");
                            productSize.setQuantity("38-43");
                            break;
                        case "M":
                            productSize.setSize("Medium");
                            productSize.setQuantity("43-46");
                            break;
                        case "L":
                            productSize.setSize("Large");
                            productSize.setQuantity("46-53");
                            break;
                        case "XL":
                            productSize.setSize("Extra Large");
                            productSize.setQuantity("53-57");
                            break;
                        case "XXL":
                            productSize.setSize("Double Extra Large");
                            productSize.setQuantity("57-66");
                            break;
                        default:
                            productSize.setSize("");
                            productSize.setQuantity("");
                            break;
                    }
                    productSize.setActiveFlag(req.getActiveFlag());
                    productSize.setSizeCode(req.getSizeCode());
                    productSize.setGender("Female");
                    break;
                default:
                    productSize.setSizeCode(req.getSizeCode());
                    productSize.setGender(req.getGender());
                    break;
            }
            productSizeDAO.update(productSize);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return productSizeDAO.findById(req.getId());
    }

    @Override
    public void delete(int id) {
        try {
            productSizeDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public ProductSizeEntity findById(int id) {
        return productSizeDAO.findById(id);
    }

    @Override
    public ProductSizeEntity findBySize(String size) {
        return productSizeDAO.findBySize(size);
    }

    @Override
    public ProductSizeEntity findByQuantity(String quantity) {
        return productSizeDAO.findByQuantity(quantity);
    }

    @Override
    public ProductSizeEntity findByGender(String gender) {
        return productSizeDAO.findByGender(gender);
    }

    @Override
    public ProductSizeEntity findBySizeCodeAndGender(String sizeCode, String gender) {
        return productSizeDAO.findBySizeCodeAndGender(sizeCode, gender);
    }

    @Override
    public List<ProductSizeEntity> findAll() {
        return productSizeDAO.findAll();
    }
}
