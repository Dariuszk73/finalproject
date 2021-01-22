package pl.sda.java.project.finalproject.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.java.project.finalproject.entities.EventEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Long> {


List<EventEntity> findAllByStartDateAfter(LocalDateTime localDateTime, Sort sort);

List<EventEntity> findByTitleContainingAndStartDateAfter(String title, LocalDateTime localDateTime, Sort sort);

List<EventEntity> findByTitleContainingAndEndDateGreaterThanEqual(String title, LocalDateTime localDateTime, Sort sort);

List<EventEntity> findByTitleContaining(String title, Sort sort);

boolean existsByIdAndUserEntityEmail(Long id, String email);

boolean existsByIdAndSignedUpEmail(Long eventId, String email);

}
