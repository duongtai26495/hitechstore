package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.entities.Brand;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.repositories.BrandRepository;
import net.accessory.hitechstore.histore.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;


    private final String DATE_PATTERN = "dd/MM/yy hh:mm:ss";

    private String getUsernameLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> addNewBrand(Brand brand) {
        if (getUsernameLogin()!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("SUCCESS","Create new brand is successful",brandRepository.save(brand))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("FAILURE","Create new brand is failure, user do not login",null)
        );

    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<ResponseObject> editById(Brand brand) {
        Brand getBrand = brandRepository.findById(brand.getId()).get();
        getBrand.setName(brand.getName());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESS","Edit brand success",brandRepository.save(getBrand))
        );
    }
}