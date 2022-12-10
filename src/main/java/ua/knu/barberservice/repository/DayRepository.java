package ua.knu.barberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.barberservice.domain.BookEntity;
import ua.knu.barberservice.domain.DayEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<DayEntity, Long> {
  DayEntity findByDate(Date date);
}
