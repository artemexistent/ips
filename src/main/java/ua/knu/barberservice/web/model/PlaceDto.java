package ua.knu.barberservice.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder
public class PlaceDto {
  String address;
}
