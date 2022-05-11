package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.entity.ImageEntity;
import com.hoangbui.shopping.model.req.create.CreateImageReq;
import com.hoangbui.shopping.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @Override
    public ImageEntity uploadFile(CreateImageReq req, MultipartFile file) {
        return null;
    }

    @Override
    public ImageEntity storeImage(int id, MultipartFile file) {
        return null;
    }

    @Override
    public void deleteImage(int imageId) {

    }

    @Override
    public ImageEntity getImage(int id) {
        return null;
    }
}
