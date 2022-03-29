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
            ProductSizeEntity check = productSizeDAO.findBySize(req.getSize());
            if (check != null) {
                throw new DuplicateRecordException("exist");
            } else {
                ProductSizeEntity productSize = new ProductSizeEntity();
                if(productSize.getQuantity() == null) {
                    switch (req.getGender()) {
                        case "Male":
                            switch (req.getSize()) {
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
                            productSize.setGender("Male");
                            break;
                        case "Female":
                            switch (req.getSize()) {
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
                            productSize.setGender("Female");
                            break;
                        default:
                            switch (req.getSize()) {
                                case "XS":
                                    productSize.setSize("Extra Small");
                                    break;
                                case "S":
                                    productSize.setSize("Small");
                                    break;
                                case "M":
                                    productSize.setSize("Medium");
                                    break;
                                case "L":
                                    productSize.setSize("Large");
                                    break;
                                case "XL":
                                    productSize.setSize("Extra Large");
                                    break;
                                case "XXL":
                                    productSize.setSize("Double Extra Large");
                                    break;
                                default:
                                    productSize.setSize(req.getSize());
                                    break;
                            }
                            productSize.setGender(req.getGender());
                            productSize.setQuantity(req.getQuantity());
                            break;
                    }
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
        try {
            productSize.setSize(req.getSize());
            if (productSize.getQuantity() == null) {
                switch (req.getGender()) {
                    case "Male":
                        switch (req.getSize()) {
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
                        productSize.setGender("Male");
                        break;
                    case "Female":
                        switch (req.getSize()) {
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
                        productSize.setGender("Female");
                        break;
                    default:
                        switch (req.getSize()) {
                            case "XS":
                                productSize.setSize("Extra Small");
                                break;
                            case "S":
                                productSize.setSize("Small");
                                break;
                            case "M":
                                productSize.setSize("Medium");
                                break;
                            case "L":
                                productSize.setSize("Large");
                                break;
                            case "XL":
                                productSize.setSize("Extra Large");
                                break;
                            case "XXL":
                                productSize.setSize("Double Extra Large");
                                break;
                            default:
                                productSize.setSize(req.getSize());
                                break;
                        }
                        productSize.setGender(req.getGender());
                        productSize.setQuantity(req.getQuantity());
                        break;
                }
            }
            productSize.setActiveFlag(req.getActiveFLag());
            productSizeDAO.update(productSize);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return productSize;
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
    public List<ProductSizeEntity> findAll() {
        return productSizeDAO.findAll();
    }
}
