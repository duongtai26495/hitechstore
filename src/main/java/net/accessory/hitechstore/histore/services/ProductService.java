package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.Product;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll(int page, int size);

    ResponseEntity<ResponseObject> saveNew(Product product);

    ResponseEntity<ResponseObject> editById(Product product);

    ResponseEntity<ResponseObject> deleteById(Long id);

    ResponseEntity<ResponseObject> getProductById(Long id);

    boolean isExistByName(String name);

}
