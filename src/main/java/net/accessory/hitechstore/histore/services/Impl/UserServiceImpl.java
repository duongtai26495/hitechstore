package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.configs.MyUserDetail;
import net.accessory.hitechstore.histore.entities.*;
import net.accessory.hitechstore.histore.repositories.UserRepository;
import net.accessory.hitechstore.histore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
     UserRepository userRepository;

    @Autowired
     RoleServiceImpl roleService;

    @Autowired
     PasswordEncoder passwordEncoder;

    private final String DATE_PATTERN = "dd/MM/yy hh:mm:ss";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new MyUserDetail(user);
    }
    public UserServiceImpl() {

    }

    @Override
    public ResponseEntity<ResponseObject> saveNewUser(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED","This user with username "+user.getUsername()+" already taken!",null)
            );
        }
        if(userRepository.findByEmail(user.getEmail()) != null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED","This user with email "+user.getEmail()+" already taken!",null)
            );
        }
        List<Role> roleList = roleService.getAll();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        user.setJoinedAt(sdf.format(date));
        user.setLastEdited(sdf.format(date));
        user.setRole(roleList.get(0));
        user.setGender(0);
        user.setActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserDTO userDTO = ConvertUser.convertToDTO(userRepository.save(user));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESSFULLY","User created",userDTO)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> editUserByUsername(User user) {
        return null;
    }
}
