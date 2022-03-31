package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.ProductSizeEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateProductSizeReq;
import com.hoangbui.shopping.model.req.update.UpdateProductSizeReq;
import com.hoangbui.shopping.service.ProductSizeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/product-size")
@CrossOrigin(origins = "*")
public class ManagementProductSizeController {
    final Logger log = Logger.getLogger(ManagementProductSizeController.class);

    @Autowired
    private ProductSizeService productSizeService;

    @GetMapping("/findAll")
    private ResponseEntity<?> findAll(){
        List<ProductSizeEntity> productSize = productSizeService.findAll();
        return new ResponseEntity<>(productSize, HttpStatus.OK);
    }

    @GetMapping("/findId")
    private ResponseEntity<?> findById(@RequestParam int id){
        ProductSizeEntity productSize = productSizeService.findById(id);
        return new ResponseEntity<>(productSize, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<?> create(@Valid @RequestBody CreateProductSizeReq req){
        ProductSizeEntity check = productSizeService.findBySizeCodeAndGender(req.getSizeCode(), req.getGender());
        if(check != null){
            throw new DuplicateRecordException("Exist");
        } else {
            ProductSizeEntity productSize = productSizeService.save(req);
            return new ResponseEntity<>(productSize, HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    private ResponseEntity<?> update(@Valid @RequestBody UpdateProductSizeReq req){
            ProductSizeEntity productSize = productSizeService.update(req);
            return new ResponseEntity<>(productSize, HttpStatus.OK);
    }

}
