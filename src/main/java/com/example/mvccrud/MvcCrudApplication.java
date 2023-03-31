package com.example.mvccrud;

import com.example.mvccrud.dao.RoleDao;
import com.example.mvccrud.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class MvcCrudApplication {

    @Autowired
    private RoleDao roleDao;

    @Bean @Profile("db")
    @Transactional
    public ApplicationRunner runner() {
        return r -> {
            Role role = new Role();
            role.setName("ROLE_USER");
            roleDao.save(role);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MvcCrudApplication.class, args);
    }

}
