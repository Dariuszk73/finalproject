package pl.sda.java.project.finalproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String nickname;

    private String password;

    public UserEntity(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public UserEntity() {

    }

    private LocalDateTime created = LocalDateTime.now();

    @ManyToMany
    @JoinTable(name = "users_roles")
    private Set<RoleEntity> roles = new HashSet<>();

    public void addRole(RoleEntity roleEntity) {
        roles.add(roleEntity);
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }
}

