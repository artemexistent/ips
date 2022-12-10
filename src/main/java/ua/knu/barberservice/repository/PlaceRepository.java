package ua.knu.barberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.barberservice.domain.PlaceEntity;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
  PlaceEntity findByAddress(String address);
}
