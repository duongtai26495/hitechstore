package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.entities.Category;
import net.accessory.hitechstore.histore.entities.ConvertCodeName;
import net.accessory.hitechstore.histore.entities.GetCurrentUsername;
import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.repositories.CategoryRepository;
import net.accessory.hitechstore.histore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private final String DATE_PATTERN = "dd/MM/yy hh:mm:ss";



    @Override
    public ResponseEntity<ResponseObject> saveNewCategory(Category category) {
        String currentUsername = GetCurrentUsername.getUsernameLogin();
        if (currentUsername!=null){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
            category.setCode_name(ConvertCodeName.convert(category.getName()));
            category.setCreated_at(sdf.format(date));
            category.setLast_edited_at(category.getCreated_at());
            category.setAuthor(currentUsername);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("SUCCESS","Create new category is successful",categoryRepository.save(category))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("FAILURE","Create new category is failure, user do not login",null)
        );

    }

    @Override
    public ResponseEntity<ResponseObject> editCategoryById(Category category) {
        if (categoryRepository.existsById(category.getId())){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
            Category categoryFound = categoryRepository.findById(category.getId()).get();
            categoryFound.setActive(category.isActive());
            categoryFound.setName(category.getName());
            categoryFound.setLast_edited_at(sdf.format(date));

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("SUCCESS","Edit category is successful",categoryRepository.save(categoryFound))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("FAILURE","Category is not found",null)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESS","All of category", categoryRepository.findAll())
        );
    }
}
