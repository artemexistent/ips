package ua.knu.barberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.barberservice.domain.BarberEntity;

import java.util.List;

@Repository
public interface BarberRepository extends JpaRepository<BarberEntity, Long> {
  List<BarberEntity> findAllByBarberName(String barberName);
  List<BarberEntity> findAllByPlaceId(Long place_id);
}
