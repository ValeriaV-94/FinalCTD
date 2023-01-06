package com.integrador.backend.login;

import com.integrador.backend.model.User;
import com.integrador.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String hash_user = passwordEncoder.encode("123");
        User user = new User("Ernesto", "Perez", "ernesto.perez@hotmail.com", hash_user, "Buenos Aires", UserRole.USER_ROLE);
        userRepository.save(user);
    }
}
