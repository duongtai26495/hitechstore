package net.accessory.hitechstore.histore.controllers;

import net.accessory.hitechstore.histore.entities.Product;
import net.accessory.hitechstore.histore.entities.ProductImage;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.services.Impl.CategoryServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.ImageServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.ProductImageServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product/")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ImageServiceImpl imageService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductImageServiceImpl productImageService;

    @PostMapping("uploadImage")
    public String uploadImage(@RequestParam("image")MultipartFile file){
      return imageService.storeFile(file);
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

    @PostMapping("add_image")
    public ResponseEntity<ResponseObject> addImageProduct (@RequestBody ProductImage productImage){
        return productImageService.saveImageWithProductId(productImage);
    }
}
