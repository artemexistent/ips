package ua.knu.barberservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder(toBuilder = true)
public class BarberModel {
  String name;
  Integer rating;
  Integer cost;
}
