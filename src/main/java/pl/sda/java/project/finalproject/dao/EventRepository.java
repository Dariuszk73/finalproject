package pl.sda.java.project.finalproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.java.project.finalproject.entities.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
