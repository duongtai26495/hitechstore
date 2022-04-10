package net.accessory.hitechstore.histore.controllers;

import net.accessory.hitechstore.histore.entities.Product;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.entities.User;
import net.accessory.hitechstore.histore.services.Impl.CategoryServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.ImageServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.ProductServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/api/")
@CrossOrigin
public class HomeController {
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ImageServiceImpl imageService;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("categories")
    public ResponseEntity<ResponseObject> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("products")
    public List<Product> getAllProducts(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "12") Integer per){
        return productService.getAll(page,per);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<ResponseObject> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("images/{fileName:.+}")
    public ResponseEntity<byte[]> readFile (@PathVariable String fileName){
        return imageService.readFile(fileName);
    }

    @PostMapping("register")
    public ResponseEntity<ResponseObject> register(@RequestBody User user){
        return userService.saveNewUser(user);
    }
}
