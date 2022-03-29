package net.accessory.hitechstore.histore.configs;

import net.accessory.hitechstore.histore.entities.Role;
import net.accessory.hitechstore.histore.services.Impl.RoleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase(RoleServiceImpl roleService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Role role_user = new Role("ROLE_USER");
                Role role_admin = new Role("ROLE_ADMIN");
                roleService.saveNewRole(role_user);
                roleService.saveNewRole(role_admin);
            }
        };
    }
}
