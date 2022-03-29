package net.accessory.hitechstore.histore.controllers;

import net.accessory.hitechstore.histore.entities.Product;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("all")
    public List<Product> getAllProducts(@RequestParam("page") Integer page, @RequestParam("per") Integer per){
        return productService.getAll(page,per);
    }

    @PostMapping("new")
    public ResponseEntity<ResponseObject> newProduct(@RequestBody Product product){
        return productService.saveNew(product);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<ResponseObject> editProduct(@RequestBody Product product, @PathVariable Long id){
        product.setId(id);
        return productService.editById(product);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        return productService.deleteById(id);
    }
}
