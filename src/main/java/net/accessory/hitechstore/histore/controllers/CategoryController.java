package net.accessory.hitechstore.histore.controllers;

import net.accessory.hitechstore.histore.entities.Category;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping("new")
    public ResponseEntity<ResponseObject> createNew(@RequestBody Category category){
        return categoryService.saveNewCategory(category);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<ResponseObject> editCategory(@PathVariable Long id,@RequestBody Category category){
        category.setId(id);
        return categoryService.editCategoryById(category);
    }


}
