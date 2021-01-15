package pl.sda.java.project.finalproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.sda.java.project.finalproject.dao.UserRepository;
import pl.sda.java.project.finalproject.dtos.UserSessionDto;





@Service
@SessionScope
public class LoginService implements InitializingBean {
    private final UserRepository userRepository;

    private boolean logged;
    private UserSessionDto userSessionDto;

    public LoginService(UserRepository userRepository) {
        logged = false;
        this.userRepository = userRepository;
    }
//    public void loginUser(String username, String password) {
//
//
//        final UserEntity userEntity = userRepository.findUserByLogin(username)
//                .orElseThrow(() -> new UserDoesntExistException(username));
//
//        if (!userEntity.getPassword().equals(password)) {
//            throw new InvalidCredentialsException("invalid password");
//        }
//
//        this.userSessionDto = new UserSessionDto(userEntity.getEmail(), userEntity.getNickname());
//        this.logged = true;
//    }

    public boolean isLogged() {
        return logged;
    }

    public UserSessionDto getUserSessionDto() {
        return userSessionDto;
    }

    public void logout() {
        this.logged = false;
        this.userSessionDto = null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
