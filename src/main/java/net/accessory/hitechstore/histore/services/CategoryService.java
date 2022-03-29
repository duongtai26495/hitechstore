package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.Category;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<ResponseObject> saveNewCategory (Category category);
    ResponseEntity<ResponseObject> editCategoryById (Category category);
    ResponseEntity<ResponseObject> getAll();
}
