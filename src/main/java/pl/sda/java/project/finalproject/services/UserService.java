package pl.sda.java.project.finalproject.services;

import org.springframework.stereotype.Service;
import pl.sda.java.project.finalproject.dao.UserRepository;
import pl.sda.java.project.finalproject.dtos.NewUserForm;
import pl.sda.java.project.finalproject.entities.UserEntity;
import pl.sda.java.project.finalproject.exceptions.UserWithSuchEmailExistsExepction;

import javax.management.relation.Role;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void registerUser(NewUserForm newUserForm) {
        final boolean existsByEmail = userRepository.existsByEmail(newUserForm.getEmail());
        if (existsByEmail) {
            throw new UserWithSuchEmailExistsExepction(newUserForm.getEmail());
        }

        final UserEntity user = new UserEntity();
        user.setEmail(newUserForm.getEmail());
        user.setNickname(newUserForm.getNickname());
        user.setPassword(newUserForm.getPassword());

        userRepository.save(user);
    }
}
