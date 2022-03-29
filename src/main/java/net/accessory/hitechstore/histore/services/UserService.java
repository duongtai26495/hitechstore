package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ResponseObject> saveNewUser(User user);

    ResponseEntity<ResponseObject> editUserByUsername(User user);

    ResponseEntity<ResponseObject>  updatePassword(User user);

}
