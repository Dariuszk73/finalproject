package pl.sda.java.project.finalproject.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.java.project.finalproject.entities.EventEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Long> {


List<EventEntity> findAllByStartDateAfter(LocalDateTime localDateTime, Sort sort);

}
