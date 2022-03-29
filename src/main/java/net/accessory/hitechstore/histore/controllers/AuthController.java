package net.accessory.hitechstore.histore.controllers;

import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.entities.User;
import net.accessory.hitechstore.histore.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("register")
    public ResponseEntity<ResponseObject> register(@RequestBody User user){
        return userService.saveNewUser(user);
    }

    @PutMapping("edit/{username}")
    public ResponseEntity<ResponseObject> updateInfo(@PathVariable String username, @RequestBody User user){
        user.setUsername(username);
        return userService.editUserByUsername(user);
    }

    @PutMapping("updatepw/{username}")
    public ResponseEntity<ResponseObject> updatePassword(@PathVariable String username, @RequestBody User user){
        user.setUsername(username);
        return  userService.updatePassword(user);
    }

}
