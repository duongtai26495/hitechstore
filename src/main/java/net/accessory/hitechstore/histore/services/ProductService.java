package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<ResponseObject> getAll();
}
