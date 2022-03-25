package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.BrandDAO;
import com.hoangbui.shopping.entity.BrandEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateBrandReq;
import com.hoangbui.shopping.model.req.update.UpdateBrandReq;
import com.hoangbui.shopping.service.BrandService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandServiceImpl implements BrandService {
    final Logger log = Logger.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandDAO<BrandEntity> brandDAO;

    @Override
    public BrandEntity save(CreateBrandReq req) {
        int id = 0;
        try {
            BrandEntity result = brandDAO.findByBrandName(req.getBrandName());
            if(result == null) {
                BrandEntity brand = new BrandEntity();
                brand.setBrandName(req.getBrandName());
                brand.setThumbnail(req.getThumbnail());
                id = brandDAO.save(brand);
            } else {
                throw new DuplicateRecordException("Brand Name exists");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return brandDAO.findById(id);
    }

    @Override
    public BrandEntity update(UpdateBrandReq req) {
        try {
            BrandEntity brand = new BrandEntity();
            brand.setBrandName(req.getBrandName());
            brand.setThumbnail(req.getThumbnail());
            brand.setActiveFlag(req.getActiveFlag());
            brandDAO.update(brand);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return brandDAO.findByBrandName(req.getBrandName());
    }

    @Override
    public void delete(int id) {
        try {
            brandDAO.delete(id);
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public BrandEntity findById(int id) {
        BrandEntity brand = brandDAO.findById(id);
        return brand;
    }

    @Override
    public BrandEntity findByBrandName(String brandName) {
        return brandDAO.findByBrandName(brandName);
    }

    @Override
    public List<BrandEntity> findAll() {
        return brandDAO.findAll();
    }
}
