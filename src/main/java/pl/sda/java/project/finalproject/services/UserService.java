package pl.sda.java.project.finalproject.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.java.project.finalproject.dao.UserRepository;
import pl.sda.java.project.finalproject.dtos.NewUserForm;
import pl.sda.java.project.finalproject.entities.UserEntity;
import pl.sda.java.project.finalproject.exceptions.UserWithSuchEmailExistsExepction;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(NewUserForm newUserForm) {
        final boolean existsByEmail = userRepository.existsByEmail(newUserForm.getEmail());
        if (existsByEmail) {
            throw new UserWithSuchEmailExistsExepction(newUserForm.getEmail());
        }
//final String roleName = "COMMON_USER";

        final UserEntity user = new UserEntity();
        user.setEmail(newUserForm.getEmail());
        user.setNickname(newUserForm.getNickname());
        user.setPassword(passwordEncoder.encode(newUserForm.getPassword()));


        userRepository.save(user);
    }
}
