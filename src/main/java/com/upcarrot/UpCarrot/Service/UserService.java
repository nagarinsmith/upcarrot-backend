package com.upcarrot.UpCarrot.Service;

import com.upcarrot.UpCarrot.Model.User;
import com.upcarrot.UpCarrot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserByEmail(String email){
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    public User register(String email, String password){
        return userRepository.insert(new User(email, bCryptPasswordEncoder.encode(password)));
    }

}
