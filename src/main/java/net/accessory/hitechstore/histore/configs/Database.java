package net.accessory.hitechstore.histore.configs;

import net.accessory.hitechstore.histore.entities.Role;
import net.accessory.hitechstore.histore.entities.User;
import net.accessory.hitechstore.histore.services.Impl.RoleServiceImpl;
import net.accessory.hitechstore.histore.services.Impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase(RoleServiceImpl roleService,
                                   UserServiceImpl userService,
                                   PasswordEncoder passwordEncoder){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Role role_user = new Role("ROLE_USER");
                Role role_admin = new Role("ROLE_ADMIN");
                User user_admin = new User();
                user_admin.setFull_name("Dương Minh Tài");
                user_admin.setUsername("duongtai264");
                user_admin.setEmail("duongtai.264@gmail.com");
                user_admin.setGender(1);
                user_admin.setActive(1);
                user_admin.setPassword("Blackhat1");
                user_admin.setRole(role_admin);
                userService.saveNewUser(user_admin);
                roleService.saveNewRole(role_user);
                roleService.saveNewRole(role_admin);
            }
        };
    }
}
