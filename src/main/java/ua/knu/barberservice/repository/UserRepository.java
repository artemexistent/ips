package ua.knu.barberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.barberservice.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUserId(Long userId);
}
