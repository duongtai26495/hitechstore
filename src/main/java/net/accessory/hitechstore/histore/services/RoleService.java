package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.ResponseObject;
import net.accessory.hitechstore.histore.entities.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {
    ResponseEntity<ResponseObject> saveNewRole(Role role);
    Role getRoleByName(String name);
    List<Role> getAll();
}
