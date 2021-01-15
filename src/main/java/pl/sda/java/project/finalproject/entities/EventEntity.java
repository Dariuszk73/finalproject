package pl.sda.java.project.finalproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    private String startDate;

    private String endDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "user_entity_id")
    private UserEntity userEntity;
}
