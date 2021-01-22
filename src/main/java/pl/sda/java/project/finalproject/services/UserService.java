package pl.sda.java.project.finalproject.services;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.java.project.finalproject.dao.RoleRepository;
import pl.sda.java.project.finalproject.dao.UserRepository;
import pl.sda.java.project.finalproject.dtos.request.NewUserForm;
import pl.sda.java.project.finalproject.entities.RoleEntity;
import pl.sda.java.project.finalproject.entities.UserEntity;
import pl.sda.java.project.finalproject.exceptions.UserWithSuchEmailExistsExepction;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void registerUser(NewUserForm newUserForm) {
        final boolean existsByEmail = userRepository.existsByEmail(newUserForm.getEmail());
        if (existsByEmail) {
            throw new UserWithSuchEmailExistsExepction(newUserForm.getEmail());
        }
        final String roleName = "COMMON_USER";
        final RoleEntity role = roleRepository.findByRoleName(roleName)
                .orElseGet(() -> roleRepository.save(new RoleEntity(roleName)));

        final UserEntity user = new UserEntity();
        user.setEmail(newUserForm.getEmail());
        user.setNickname(newUserForm.getNickname());
        user.setPassword(passwordEncoder.encode(newUserForm.getPassword()));
        user.addRole(role);

        userRepository.save(user);
    }
}
