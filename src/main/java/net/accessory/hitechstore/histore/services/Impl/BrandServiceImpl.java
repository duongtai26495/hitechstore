package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.entities.Brand;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.repositories.BrandRepository;
import net.accessory.hitechstore.histore.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;


    @Override
    public ResponseEntity<ResponseObject> addNewBrand(Brand brand) {
        return null;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<ResponseObject> editById(Brand brand) {
        Brand getBrand = brandRepository.findById(brand.getId()).get();
        getBrand.setName(brand.getName());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESS","Edit brand success",brandRepository.save(getBrand))
        );
    }
}