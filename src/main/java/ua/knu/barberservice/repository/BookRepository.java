package ua.knu.barberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.barberservice.domain.BarberEntity;
import ua.knu.barberservice.domain.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
  List<BookEntity> findAllByUserId(Long userId);
  List<BookEntity> findAllByBarberId(Long barberId);
}
