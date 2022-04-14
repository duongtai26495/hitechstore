package net.accessory.hitechstore.histore.controllers;

import net.accessory.hitechstore.histore.entities.Brand;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.services.Impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
public class BrandController {

    @Autowired
    private BrandServiceImpl brandService;


    @PostMapping("new")
    public ResponseEntity<ResponseObject> newBrand (@RequestBody Brand brand){
        return brandService.addNewBrand(brand);
    }
}
