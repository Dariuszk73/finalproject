package pl.sda.java.project.finalproject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.java.project.finalproject.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findUserEntityByEmail(String email);
}
