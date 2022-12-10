package ua.knu.barberservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import jakarta.persistence.Id;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "barber")
public class BarberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  Long id;

  @Column(name = "barber_name")
  String barberName;

  @Column(name = "rating")
  Integer rating;

  @Column(name = "cost")
  Integer cost;

  @ManyToMany(fetch = FetchType.EAGER)
//  @Fetch(value = FetchMode.SUBSELECT)
  @JoinTable(name = "day_of_works",
      joinColumns = @JoinColumn(name = "barber_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "day_id", referencedColumnName = "id"))
  List<DayEntity> days;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
  PlaceEntity place;
}
