package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.ImageEntity;
import com.hoangbui.shopping.model.req.create.CreateImageReq;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    ImageEntity uploadFile(CreateImageReq req, MultipartFile file);

    ImageEntity storeImage(int id, MultipartFile file);

    void deleteImage(int imageId);

    ImageEntity getImage(int id);
}
