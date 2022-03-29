package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ResponseEntity<ResponseObject> getAll() {
        return null;
    }
}
