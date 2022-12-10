package ua.knu.barberservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = true)
  Long id;

  @Column(name = "user_id")
  Long userId;

  @Column(name = "barber_id")
  Long barberId;

  @Column(name = "day_id")
  Long dayId;

  @Column(name = "time_id")
  Integer timeId;
}
