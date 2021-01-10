package pl.sda.java.project.finalproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.sda.java.project.finalproject.dao.UserRepository;
import pl.sda.java.project.finalproject.dtos.UserSessionDto;
import pl.sda.java.project.finalproject.entities.UserEntity;
import pl.sda.java.project.finalproject.exceptions.InvalidCredentialsException;
import pl.sda.java.project.finalproject.exceptions.UserDoesntExistException;

import java.util.UUID;
@Service
@SessionScope
@Slf4j
public class LoginService implements InitializingBean {
    private final UserRepository userRepository;
    private UserSessionDto userSessionDto;

    private UUID uuid;

    private boolean logged;


    public LoginService(UserRepository userRepository) {
        uuid = UUID.randomUUID();
        logged = false;
        log.info("LoginService creating instance: {}", uuid.toString());
        this.userRepository = userRepository;
    }
    public void loginUser(String username, String password) {
        log.info("LoginService loginUser: {} / {}", username, uuid.toString());

        final UserEntity userEntity = userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UserDoesntExistException(username));

        if (!userEntity.getPassword().equals(password)) {
            throw new InvalidCredentialsException("invalid password");
        }

        this.userSessionDto = new UserSessionDto(userEntity.getEmail(), userEntity.getNickname());
        this.logged = true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
