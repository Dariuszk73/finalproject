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
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "user_entity_id")
    private UserEntity userEntity;
    @ManyToMany
    @JoinColumn(name = "users_signed_events")
    private final Set<UserEntity> signedUp = new HashSet<>();
    public void signUp(UserEntity userEntity){
        signedUp.add(userEntity);
    }
}
