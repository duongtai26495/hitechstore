package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.Brand;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    ResponseEntity<ResponseObject> addNewBrand(Brand brand);

    List<Brand> getAll();

    void deleteById(Long id);

    ResponseEntity<ResponseObject> editById(Brand brand);
}
