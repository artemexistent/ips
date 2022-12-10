package ua.knu.barberservice.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.Date;

@Value
@Data
@Builder
public class BookDto {
  String barberName;
  Long userId;
  Date date;
  Integer time;
}
