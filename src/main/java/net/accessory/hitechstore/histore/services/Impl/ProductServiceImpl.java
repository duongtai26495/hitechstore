package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.entities.Product;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.entities.User;
import net.accessory.hitechstore.histore.repositories.ProductRepository;
import net.accessory.hitechstore.histore.repositories.UserRepository;
import net.accessory.hitechstore.histore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;




    private final String DATE_PATTERN = "dd/mm/yy hh:mm:ss";


    @Override
    public List<Product> getAll(int page, int size) {
        productRepository.findAll();
        Pageable paging = PageRequest.of(page,size);
        Page<Product> productPage = productRepository.findAll(paging);
        return productPage.toList();
    }

    @Override
    public ResponseEntity<ResponseObject> saveNew(Product product) {
        List<Product> products = productRepository.findAll();
        boolean isExist = false;
        for (Product check: products) {
            if (check.getName().
                    toLowerCase().
                    trim().
                    equals(product.getName().
                            toLowerCase().
                            trim())) {
                isExist = true;
                break;
            }
        }
        if(!isExist){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
            product.setCreatedAt(sdf.format(date));
            product.setLastEditedAt(product.getCreatedAt());
            product.setAuthor(SecurityContextHolder.getContext().getAuthentication().getName());
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESS","Create new product is successful",productRepository.save(product))
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILURE","Category with this name already taken",null)
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> editById(Product product) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
       if (productRepository.existsById(product.getId())){
           Product getProduct = productRepository.findById(product.getId()).get();
           getProduct.setId(product.getId());
           getProduct.setActive(product.isActive());
           getProduct.setImageUrl(product.getImageUrl());
           getProduct.setName(product.getName());
           getProduct.setLastEditedAt(sdf.format(date));
           getProduct.setCategory(product.getCategory());
           return ResponseEntity.status(HttpStatus.OK).body(
                   new ResponseObject("SUCCESS","Edit product is successful",productRepository.save(getProduct))
           );
       }else{
           return saveNew(product);
       }


    }

    @Override
    public ResponseEntity<ResponseObject> deleteById(Long id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("SUCCESS","Delete product is successful",null)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED","Product not found",null)
            );
        }
    }


}
